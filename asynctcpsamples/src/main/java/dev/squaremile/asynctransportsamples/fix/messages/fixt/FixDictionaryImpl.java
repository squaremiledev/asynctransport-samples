/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt;

import uk.co.real_logic.artio.dictionary.FixDictionary;
import uk.co.real_logic.artio.builder.AbstractLogonEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.LogonEncoder;
import uk.co.real_logic.artio.builder.AbstractResendRequestEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.ResendRequestEncoder;
import uk.co.real_logic.artio.builder.AbstractLogoutEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.LogoutEncoder;
import uk.co.real_logic.artio.builder.AbstractHeartbeatEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.HeartbeatEncoder;
import uk.co.real_logic.artio.builder.AbstractRejectEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.RejectEncoder;
import uk.co.real_logic.artio.builder.AbstractTestRequestEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.TestRequestEncoder;
import uk.co.real_logic.artio.builder.AbstractSequenceResetEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.SequenceResetEncoder;
import uk.co.real_logic.artio.builder.AbstractBusinessMessageRejectEncoder;
import uk.co.real_logic.artio.decoder.AbstractLogonDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.LogonDecoder;
import uk.co.real_logic.artio.decoder.AbstractLogoutDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.LogoutDecoder;
import uk.co.real_logic.artio.decoder.AbstractRejectDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.RejectDecoder;
import uk.co.real_logic.artio.decoder.AbstractTestRequestDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.TestRequestDecoder;
import uk.co.real_logic.artio.decoder.AbstractSequenceResetDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.SequenceResetDecoder;
import uk.co.real_logic.artio.decoder.AbstractHeartbeatDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.HeartbeatDecoder;
import uk.co.real_logic.artio.decoder.AbstractResendRequestDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.ResendRequestDecoder;
import uk.co.real_logic.artio.decoder.AbstractUserRequestDecoder;
import uk.co.real_logic.artio.decoder.SessionHeaderDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.HeaderDecoder;
public class FixDictionaryImpl implements FixDictionary
{
    public String beginString()
    {
        return "FIXT.1.1";
    }

    public SessionHeaderDecoder makeHeaderDecoder()
    {
        return new HeaderDecoder();
    }

    public AbstractLogonEncoder makeLogonEncoder()
    {
        return new LogonEncoder();
    }

    public AbstractResendRequestEncoder makeResendRequestEncoder()
    {
        return new ResendRequestEncoder();
    }

    public AbstractLogoutEncoder makeLogoutEncoder()
    {
        return new LogoutEncoder();
    }

    public AbstractHeartbeatEncoder makeHeartbeatEncoder()
    {
        return new HeartbeatEncoder();
    }

    public AbstractRejectEncoder makeRejectEncoder()
    {
        return new RejectEncoder();
    }

    public AbstractTestRequestEncoder makeTestRequestEncoder()
    {
        return new TestRequestEncoder();
    }

    public AbstractSequenceResetEncoder makeSequenceResetEncoder()
    {
        return new SequenceResetEncoder();
    }

    public AbstractBusinessMessageRejectEncoder makeBusinessMessageRejectEncoder()
    {
        return null;
    }

    public AbstractLogonDecoder makeLogonDecoder()
    {
        return new LogonDecoder();
    }

    public AbstractLogoutDecoder makeLogoutDecoder()
    {
        return new LogoutDecoder();
    }

    public AbstractRejectDecoder makeRejectDecoder()
    {
        return new RejectDecoder();
    }

    public AbstractTestRequestDecoder makeTestRequestDecoder()
    {
        return new TestRequestDecoder();
    }

    public AbstractSequenceResetDecoder makeSequenceResetDecoder()
    {
        return new SequenceResetDecoder();
    }

    public AbstractHeartbeatDecoder makeHeartbeatDecoder()
    {
        return new HeartbeatDecoder();
    }

    public AbstractResendRequestDecoder makeResendRequestDecoder()
    {
        return new ResendRequestDecoder();
    }

    public AbstractUserRequestDecoder makeUserRequestDecoder()
    {
        return null;
    }

}
