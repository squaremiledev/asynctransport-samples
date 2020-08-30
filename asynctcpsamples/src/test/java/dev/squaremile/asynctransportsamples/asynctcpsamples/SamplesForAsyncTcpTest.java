package dev.squaremile.asynctransportsamples.asynctcpsamples;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import dev.squaremile.asynctcp.application.TransportAppLauncher;
import dev.squaremile.asynctcp.domain.api.Transport;
import dev.squaremile.asynctcp.domain.api.commands.Connect;
import dev.squaremile.asynctcp.domain.api.commands.Listen;
import dev.squaremile.asynctcp.domain.api.events.Connected;
import dev.squaremile.asynctcp.domain.api.events.StartedListening;
import dev.squaremile.asynctcp.testfitures.TransportEventsSpy;

import static dev.squaremile.asynctcp.testfitures.FreePort.freePort;

class SamplesForAsyncTcpTest
{

    private TransportEventsSpy serverEvents;
    private TransportEventsSpy clientEvents;
    private Transport serverTransport;
    private Transport clientTransport;

    @BeforeEach
    void setUp() throws IOException
    {
        serverEvents = new TransportEventsSpy();
        clientEvents = new TransportEventsSpy();
        final TransportEventsRedirect serverEventsRedirect = new TransportEventsRedirect(serverEvents);
        final TransportEventsRedirect clientEventsRedirect = new TransportEventsRedirect(clientEvents);
        new TransportAppLauncher().launch(
                transport ->
                {
                    serverTransport = transport;
                    return serverEventsRedirect::onEvent;
                });
        new TransportAppLauncher().launch(
                transport ->
                {
                    clientTransport = transport;
                    return clientEventsRedirect::onEvent;
                });
    }

    @Test
    void establishConnection()
    {
        final int serverPort = freePort();
        serverTransport.handle(serverTransport.command(Listen.class).set(1, serverPort));
        assertThat(serverEvents.lastResponse(StartedListening.class, 1).port()).isEqualTo(serverPort);

        // When
        clientTransport.handle(clientTransport.command(Connect.class).set("localhost", serverPort, 2, 100));

        // Then
        Connected connected = clientEvents.lastResponse(Connected.class, 2);
        assertThat(connected.port()).isGreaterThan(0);
        assertThat(connected.remotePort()).isEqualTo(serverPort);
        assertThat(connected.connectionId()).isGreaterThan(0);
        assertThat(connected.inboundPduLimit()).isGreaterThan(0);
        assertThat(connected.outboundPduLimit()).isGreaterThan(0);
    }
}