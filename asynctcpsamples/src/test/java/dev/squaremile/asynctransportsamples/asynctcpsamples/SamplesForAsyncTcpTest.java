package dev.squaremile.asynctransportsamples.asynctcpsamples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import dev.squaremile.asynctcp.application.TransportAppLauncher;
import dev.squaremile.asynctcp.domain.api.commands.Connect;
import dev.squaremile.asynctcp.domain.api.commands.Listen;
import dev.squaremile.asynctcp.domain.api.events.Connected;
import dev.squaremile.asynctcp.domain.api.events.StartedListening;
import dev.squaremile.asynctcp.testfitures.app.WhiteboxApplication;

import static dev.squaremile.asynctcp.testfitures.FreePort.freePort;

class SamplesForAsyncTcpTest
{
    private WhiteboxApplication serverApp;
    private WhiteboxApplication clientApp;

    @BeforeEach
    void setUp()
    {
        new TransportAppLauncher().launch(
                transport ->
                {
                    // Store the reference to manipulate the underlying transport directly from the test.
                    // A standard app does not require such things.
                    serverApp = new WhiteboxApplication(transport);
                    return serverApp;
                });
        new TransportAppLauncher().launch(
                transport ->
                {
                    clientApp = new WhiteboxApplication(transport);
                    return clientApp;
                });
    }

    @Test
    void establishConnection()
    {
        final int serverPort = freePort();
        serverApp.underlyingtTansport().handle(serverApp.underlyingtTansport().command(Listen.class).set(1, serverPort));
        assertThat(serverApp.events().lastResponse(StartedListening.class, 1).port()).isEqualTo(serverPort);

        // When
        clientApp.underlyingtTansport().handle(clientApp.underlyingtTansport().command(Connect.class).set("localhost", serverPort, 2, 100));

        // Then
        Connected connected = clientApp.events().lastResponse(Connected.class, 2);
        assertThat(connected.port()).isGreaterThan(0);
        assertThat(connected.remotePort()).isEqualTo(serverPort);
        assertThat(connected.connectionId()).isGreaterThan(0);
        assertThat(connected.inboundPduLimit()).isGreaterThan(0);
        assertThat(connected.outboundPduLimit()).isGreaterThan(0);
    }
}