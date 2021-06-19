/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;

import uk.co.real_logic.artio.builder.Printer;
import uk.co.real_logic.artio.util.AsciiBuffer;

public class PrinterImpl implements Printer
{

    private final HeartbeatDecoder heartbeat = new HeartbeatDecoder();
    private final TestRequestDecoder testRequest = new TestRequestDecoder();
    private final ResendRequestDecoder resendRequest = new ResendRequestDecoder();
    private final RejectDecoder reject = new RejectDecoder();
    private final SequenceResetDecoder sequenceReset = new SequenceResetDecoder();
    private final LogoutDecoder logout = new LogoutDecoder();
    private final LogonDecoder logon = new LogonDecoder();

    public String toString(
        final AsciiBuffer input,
        final int offset,
        final int length,
        final long messageType)
    {
            if (messageType == 48L)
            {
                heartbeat.decode(input, offset, length);
                return heartbeat.toString();
            }

            if (messageType == 49L)
            {
                testRequest.decode(input, offset, length);
                return testRequest.toString();
            }

            if (messageType == 50L)
            {
                resendRequest.decode(input, offset, length);
                return resendRequest.toString();
            }

            if (messageType == 51L)
            {
                reject.decode(input, offset, length);
                return reject.toString();
            }

            if (messageType == 52L)
            {
                sequenceReset.decode(input, offset, length);
                return sequenceReset.toString();
            }

            if (messageType == 53L)
            {
                logout.decode(input, offset, length);
                return logout.toString();
            }

            if (messageType == 65L)
            {
                logon.decode(input, offset, length);
                return logon.toString();
            }

            else
            {
                throw new IllegalArgumentException("Unknown Message Type: " + messageType);
            }
    }

}
