package dev.squaremile.transport.casestudy.marketmaking.application;

import org.agrona.collections.MutableBoolean;


import dev.squaremile.asynctcp.api.AsyncTcp;
import dev.squaremile.asynctcp.api.wiring.ConnectingApplication;
import dev.squaremile.asynctcp.api.wiring.ConnectionApplicationFactory;
import dev.squaremile.asynctcp.api.transport.app.TransportApplicationOnDuty;
import dev.squaremile.transport.casestudy.marketmaking.domain.CurrentTime;

import static dev.squaremile.asynctcp.api.serialization.PredefinedTransportDelineation.lengthBasedDelineation;
import static dev.squaremile.asynctcp.api.serialization.SerializedMessageListener.NO_OP;
import static dev.squaremile.asynctcp.api.transport.values.Delineation.Type.SHORT_LITTLE_ENDIAN_FIELD;

public class InitiatorStarter
{
    private final int remotePort;
    private final String remoteHost;
    private final ConnectionApplicationFactory connectionApplicationFactory;
    private final MutableBoolean started = new MutableBoolean();
    private final String role;

    public InitiatorStarter(
            final String role,
            final String remoteHost,
            final int remotePort,
            final ConnectionApplicationFactory connectionApplicationFactory
    )
    {
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
        this.connectionApplicationFactory = connectionApplicationFactory;
        this.role = role;
    }

    public TransportApplicationOnDuty startTransport(final Runnable runUntilReady, final int timeoutMs)
    {
        if (started.get())
        {
            throw new IllegalStateException("Application already started");
        }
        final TransportApplicationOnDuty application = new AsyncTcp().create(
                role,
                128 * 1024,
                NO_OP,
                transport ->
                        new ConnectingApplication(
                                transport,
                                remoteHost,
                                remotePort,
                                lengthBasedDelineation(SHORT_LITTLE_ENDIAN_FIELD, 0, 0),
                                (connectionTransport, connectionId) ->
                                {
                                    this.started.set(true);
                                    return connectionApplicationFactory.create(connectionTransport, connectionId);
                                }
                        )
        );
        application.onStart();
        long startTime = CurrentTime.currentTime();
        while (!this.started.get() && CurrentTime.currentTime() < startTime + CurrentTime.timeFromMs(timeoutMs))
        {
            application.work();
            runUntilReady.run();
        }
        if (!this.started.get())
        {
            throw new IllegalStateException("Unable to satisfy condition within " + timeoutMs + "ms.");
        }
        return application;
    }
}
