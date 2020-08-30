package dev.squaremile.asynctransportsamples.asynctcpsamples;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import dev.squaremile.asynctcp.application.Application;
import dev.squaremile.asynctcp.application.TransportAppLauncher;
import dev.squaremile.asynctcp.domain.api.Transport;
import dev.squaremile.asynctcp.domain.api.commands.Connect;
import dev.squaremile.asynctcp.domain.api.commands.Listen;
import dev.squaremile.asynctcp.domain.api.events.Connected;
import dev.squaremile.asynctcp.domain.api.events.Event;
import dev.squaremile.asynctcp.domain.api.events.StartedListening;
import dev.squaremile.asynctcp.testfitures.TransportEventsSpy;

import static dev.squaremile.asynctcp.testfitures.FreePort.freePort;

class SamplesForAsyncTcpTest
{
    private WhiteBoxApplication serverApp;
    private WhiteBoxApplication clientApp;

    @BeforeEach
    void setUp() throws IOException
    {
        new TransportAppLauncher().launch(
                transport ->
                {
                    // Store the reference to manipulate the underlying transport directly from the test.
                    // A standard app does not require such things.
                    serverApp = new WhiteBoxApplication(transport);
                    return serverApp;
                });
        new TransportAppLauncher().launch(
                transport ->
                {
                    clientApp = new WhiteBoxApplication(transport);
                    return clientApp;
                });
    }

    @Test
    void establishConnection()
    {
        final int serverPort = freePort();
        serverApp.transport.handle(serverApp.transport.command(Listen.class).set(1, serverPort));
        assertThat(serverApp.events.lastResponse(StartedListening.class, 1).port()).isEqualTo(serverPort);

        // When
        clientApp.transport.handle(clientApp.transport.command(Connect.class).set("localhost", serverPort, 2, 100));

        // Then
        Connected connected = clientApp.events.lastResponse(Connected.class, 2);
        assertThat(connected.port()).isGreaterThan(0);
        assertThat(connected.remotePort()).isEqualTo(serverPort);
        assertThat(connected.connectionId()).isGreaterThan(0);
        assertThat(connected.inboundPduLimit()).isGreaterThan(0);
        assertThat(connected.outboundPduLimit()).isGreaterThan(0);
    }

    /**
     * A standard app should by autonomous and reactive.
     * It should not require external control apart from the injection of dependencies via a constructor.
     * This is not a standard app. All the logic lives outside it to show the transport API in the tests.
     */
    static class WhiteBoxApplication implements Application
    {
        private final TransportEventsSpy events = new TransportEventsSpy();
        private final TransportEventsRedirect eventsRedirect = new TransportEventsRedirect(events);
        private final Transport transport;

        WhiteBoxApplication(final Transport transport)
        {
            this.transport = transport;
        }

        @Override
        public void onEvent(final Event event)
        {
            eventsRedirect.onEvent(event);
        }
    }
}