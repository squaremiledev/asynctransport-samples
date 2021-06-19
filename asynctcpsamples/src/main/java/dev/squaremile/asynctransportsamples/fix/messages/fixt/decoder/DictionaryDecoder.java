/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;

import uk.co.real_logic.artio.util.AsciiBuffer;

public final class DictionaryDecoder
{

    private final DictionaryAcceptor acceptor;

    private final HeartbeatDecoder heartbeat = new HeartbeatDecoder();
    private final TestRequestDecoder testRequest = new TestRequestDecoder();
    private final ResendRequestDecoder resendRequest = new ResendRequestDecoder();
    private final RejectDecoder reject = new RejectDecoder();
    private final SequenceResetDecoder sequenceReset = new SequenceResetDecoder();
    private final LogoutDecoder logout = new LogoutDecoder();
    private final LogonDecoder logon = new LogonDecoder();

    public DictionaryDecoder(final DictionaryAcceptor acceptor)
    {
        this.acceptor = acceptor;
    }

    public void onMessage(
        final AsciiBuffer buffer,
        final int offset,
        final int length,
        final long messageType)
    {
        if (messageType == HeartbeatDecoder.MESSAGE_TYPE)
        {
            heartbeat.decode(buffer, offset, length);
            acceptor.onHeartbeat(heartbeat);
            heartbeat.reset();
        }

        else if (messageType == TestRequestDecoder.MESSAGE_TYPE)
        {
            testRequest.decode(buffer, offset, length);
            acceptor.onTestRequest(testRequest);
            testRequest.reset();
        }

        else if (messageType == ResendRequestDecoder.MESSAGE_TYPE)
        {
            resendRequest.decode(buffer, offset, length);
            acceptor.onResendRequest(resendRequest);
            resendRequest.reset();
        }

        else if (messageType == RejectDecoder.MESSAGE_TYPE)
        {
            reject.decode(buffer, offset, length);
            acceptor.onReject(reject);
            reject.reset();
        }

        else if (messageType == SequenceResetDecoder.MESSAGE_TYPE)
        {
            sequenceReset.decode(buffer, offset, length);
            acceptor.onSequenceReset(sequenceReset);
            sequenceReset.reset();
        }

        else if (messageType == LogoutDecoder.MESSAGE_TYPE)
        {
            logout.decode(buffer, offset, length);
            acceptor.onLogout(logout);
            logout.reset();
        }

        else if (messageType == LogonDecoder.MESSAGE_TYPE)
        {
            logon.decode(buffer, offset, length);
            acceptor.onLogon(logon);
            logon.reset();
        }

    }

}
