package dev.squaremile.asynctransportsamples.asynctcpsamples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SamplesForAsyncTcpTest
{
    @Test
    void shouldNothing()
    {
        SamplesForAsyncTcp samplesForAsyncTcp = new SamplesForAsyncTcp();
        assertNotNull(samplesForAsyncTcp);
//        assertNull(samplesForAsyncTcp);
    }
}