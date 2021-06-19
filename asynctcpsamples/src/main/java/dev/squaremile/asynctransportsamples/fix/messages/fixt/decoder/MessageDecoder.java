/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;

import uk.co.real_logic.artio.builder.Decoder;

public interface MessageDecoder extends Decoder
{
    HeaderDecoder header();

    TrailerDecoder trailer();
}