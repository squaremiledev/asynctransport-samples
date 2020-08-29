package dev.squaremile.asynctransportsamples.asynctcpsamples;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import dev.squaremile.asynctcp.domain.api.commands.Connect;
import dev.squaremile.asynctcp.domain.api.commands.Listen;
import dev.squaremile.asynctcp.domain.api.events.Connected;
import dev.squaremile.asynctcp.domain.api.events.StartedListening;
import dev.squaremile.asynctcp.nonblockingimpl.NonBlockingTransport;
import dev.squaremile.asynctcp.support.TransportEventsSpy;

import static dev.squaremile.asynctcp.support.FreePort.freePort;

class SamplesForAsyncTcpTest
{

    private TransportEventsSpy serverEvents;
    private TransportEventsSpy clientEvents;
    private NonBlockingTransport serverSideTransport;
    private NonBlockingTransport clientSideTransport;

    @BeforeEach
    void setUp() throws IOException
    {
        serverEvents = new TransportEventsSpy();
        clientEvents = new TransportEventsSpy();
        serverSideTransport = new NonBlockingTransport(new TransportEventsRedirect(serverEvents));
        clientSideTransport = new NonBlockingTransport(new TransportEventsRedirect(clientEvents));
    }

    @Test
    void establishConnection()
    {
        final int serverPort = freePort();
        serverSideTransport.handle(new Listen().set(1, serverPort));
        assertThat(serverEvents.lastResponse(StartedListening.class, 1).port()).isEqualTo(serverPort);

        // When
        clientSideTransport.handle(new Connect().set(serverPort, 2));

        // Then
        Connected connected = clientEvents.lastResponse(Connected.class, 2);
        assertThat(connected.port()).isGreaterThan(0);
        assertThat(connected.remotePort()).isEqualTo(serverPort);
        assertThat(connected.connectionId()).isGreaterThan(0);
        assertThat(connected.inboundPduLimit()).isGreaterThan(0);
        assertThat(connected.outboundPduLimit()).isGreaterThan(0);
    }

    @AfterEach
    void tearDown()
    {
        clientSideTransport.close();
        serverSideTransport.close();
    }
}