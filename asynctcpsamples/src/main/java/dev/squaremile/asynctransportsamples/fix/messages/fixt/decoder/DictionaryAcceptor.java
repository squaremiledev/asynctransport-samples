/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;


public interface DictionaryAcceptor
{
    void onHeartbeat(final HeartbeatDecoder decoder);

    void onTestRequest(final TestRequestDecoder decoder);

    void onResendRequest(final ResendRequestDecoder decoder);

    void onReject(final RejectDecoder decoder);

    void onSequenceReset(final SequenceResetDecoder decoder);

    void onLogout(final LogoutDecoder decoder);

    void onLogon(final LogonDecoder decoder);


}
