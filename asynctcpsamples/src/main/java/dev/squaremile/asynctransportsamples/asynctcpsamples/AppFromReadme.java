package dev.squaremile.asynctransportsamples.asynctcpsamples;

import dev.squaremile.asynctcp.api.AsyncTcp;
import dev.squaremile.asynctcp.serialization.api.SerializedMessageListener;
import dev.squaremile.asynctcp.transport.api.app.ApplicationOnDuty;
import dev.squaremile.asynctcp.transport.api.app.Event;
import dev.squaremile.asynctcp.transport.api.app.TransportApplicationOnDuty;
import dev.squaremile.asynctcp.transport.api.commands.Listen;
import dev.squaremile.asynctcp.transport.api.commands.SendData;
import dev.squaremile.asynctcp.transport.api.events.ConnectionAccepted;

import static dev.squaremile.asynctcp.serialization.api.PredefinedTransportDelineation.rawStreaming;

public class AppFromReadme
{
    public static void main(String[] args)
    {
        ApplicationOnDuty app = new AsyncTcp().create(
                "MyApp",
                1024,
                SerializedMessageListener.NO_OP,
                transport -> new TransportApplicationOnDuty()
                {
                    @Override
                    public void onStart()
                    {
                        transport.handle(transport.command(Listen.class).set(1, 8889, rawStreaming()));
                        System.out.println("now you can run `telnet localhost 8889` in the terminal");
                    }

                    @Override
                    public void onStop()
                    {
                    }

                    @Override
                    public void onEvent(final Event event)
                    {
                        System.out.println(event);
                        if (event instanceof ConnectionAccepted)
                        {
                            ConnectionAccepted connectionAccepted = (ConnectionAccepted)event;
                            transport.handle(transport.command(connectionAccepted.connectionId(), SendData.class).set("Hi!".getBytes()));
                        }
                    }
                }
        );

        app.onStart();
        while (true)
        {
            app.work();
        }
    }
}