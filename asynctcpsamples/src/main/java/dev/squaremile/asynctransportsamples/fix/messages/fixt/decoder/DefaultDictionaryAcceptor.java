/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;


public class DefaultDictionaryAcceptor implements DictionaryAcceptor
{
    @Override
    public void onHeartbeat(final HeartbeatDecoder decoder) {};

    @Override
    public void onTestRequest(final TestRequestDecoder decoder) {};

    @Override
    public void onResendRequest(final ResendRequestDecoder decoder) {};

    @Override
    public void onReject(final RejectDecoder decoder) {};

    @Override
    public void onSequenceReset(final SequenceResetDecoder decoder) {};

    @Override
    public void onLogout(final LogoutDecoder decoder) {};

    @Override
    public void onLogon(final LogonDecoder decoder) {};


}
