/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.builder;

import uk.co.real_logic.artio.builder.AbstractLogonEncoder;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Encoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.HeaderEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.TrailerEncoder;
import uk.co.real_logic.artio.fields.DecimalFloat;
import uk.co.real_logic.artio.util.MutableAsciiBuffer;
import uk.co.real_logic.artio.util.AsciiBuffer;
import uk.co.real_logic.artio.fields.LocalMktDateEncoder;
import uk.co.real_logic.artio.fields.UtcTimestampEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import uk.co.real_logic.artio.dictionary.CharArraySet;
import org.agrona.collections.IntHashSet;
import org.agrona.collections.IntHashSet.IntIterator;
import uk.co.real_logic.artio.EncodingException;
import uk.co.real_logic.artio.dictionary.CharArrayWrapper;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.AsciiSequenceView;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static uk.co.real_logic.artio.builder.Validation.CODEC_VALIDATION_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownField.CODEC_REJECT_UNKNOWN_FIELD_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownEnumValue.CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.*;


public class LogonEncoder implements AbstractLogonEncoder
{
    public long messageType()
    {
        return 65L;
    }

    public LogonEncoder()
    {
        header.msgType("A");
    }

    private final TrailerEncoder trailer = new TrailerEncoder();

    public TrailerEncoder trailer()
    {
        return trailer;
    }

    private final HeaderEncoder header = new HeaderEncoder();

    public HeaderEncoder header()
    {
        return header;
    }

    private static final int encryptMethodHeaderLength = 3;
    private static final byte[] encryptMethodHeader = new byte[] {57, 56, (byte) '='};

    private static final int heartBtIntHeaderLength = 4;
    private static final byte[] heartBtIntHeader = new byte[] {49, 48, 56, (byte) '='};

    private static final int rawDataLengthHeaderLength = 3;
    private static final byte[] rawDataLengthHeader = new byte[] {57, 53, (byte) '='};

    private static final int rawDataHeaderLength = 3;
    private static final byte[] rawDataHeader = new byte[] {57, 54, (byte) '='};

    private static final int resetSeqNumFlagHeaderLength = 4;
    private static final byte[] resetSeqNumFlagHeader = new byte[] {49, 52, 49, (byte) '='};

    private static final int nextExpectedMsgSeqNumHeaderLength = 4;
    private static final byte[] nextExpectedMsgSeqNumHeader = new byte[] {55, 56, 57, (byte) '='};

    private static final int maxMessageSizeHeaderLength = 4;
    private static final byte[] maxMessageSizeHeader = new byte[] {51, 56, 51, (byte) '='};

    private static final int testMessageIndicatorHeaderLength = 4;
    private static final byte[] testMessageIndicatorHeader = new byte[] {52, 54, 52, (byte) '='};

    private static final int usernameHeaderLength = 4;
    private static final byte[] usernameHeader = new byte[] {53, 53, 51, (byte) '='};

    private static final int passwordHeaderLength = 4;
    private static final byte[] passwordHeader = new byte[] {53, 53, 52, (byte) '='};

    private static final int defaultApplVerIDHeaderLength = 5;
    private static final byte[] defaultApplVerIDHeader = new byte[] {49, 49, 51, 55, (byte) '='};

    private int encryptMethod;

    private boolean hasEncryptMethod;

    public boolean hasEncryptMethod()
    {
        return hasEncryptMethod;
    }

    public LogonEncoder encryptMethod(int value)
    {
        encryptMethod = value;
        hasEncryptMethod = true;
        return this;
    }

    public int encryptMethod()
    {
        return encryptMethod;
    }

    public LogonEncoder encryptMethod(EncryptMethod value)
    {
        if (CODEC_VALIDATION_ENABLED)
        {
            if (value == EncryptMethod.ARTIO_UNKNOWN)
            {
                throw new EncodingException("Invalid Value Field: encryptMethod Value: " + value );
            }
            if (value == EncryptMethod.NULL_VAL)
            {
                return this;
            }
        }
        return encryptMethod(value.representation());
    }

    private int heartBtInt;

    private boolean hasHeartBtInt;

    public boolean hasHeartBtInt()
    {
        return hasHeartBtInt;
    }

    public LogonEncoder heartBtInt(int value)
    {
        heartBtInt = value;
        hasHeartBtInt = true;
        return this;
    }

    public int heartBtInt()
    {
        return heartBtInt;
    }

    private int rawDataLength;

    private boolean hasRawDataLength;

    public boolean hasRawDataLength()
    {
        return hasRawDataLength;
    }

    public LogonEncoder rawDataLength(int value)
    {
        rawDataLength = value;
        hasRawDataLength = true;
        return this;
    }

    public int rawDataLength()
    {
        return rawDataLength;
    }

    private byte[] rawData;

    private boolean hasRawData;

    public boolean hasRawData()
    {
        return hasRawData;
    }

    public LogonEncoder rawData(byte[] value)
    {
        rawData = value;
        hasRawData = true;
        return this;
    }

    public byte[] rawData()
    {
        return rawData;
    }

    public LogonEncoder rawDataAsCopy(final byte[] value, final int offset, final int length)
    {
        rawData = copyInto(rawData, value, offset, length);
        hasRawData = true;
        return this;
    }

    private boolean resetSeqNumFlag;

    private boolean hasResetSeqNumFlag;

    public boolean hasResetSeqNumFlag()
    {
        return hasResetSeqNumFlag;
    }

    public LogonEncoder resetSeqNumFlag(boolean value)
    {
        resetSeqNumFlag = value;
        hasResetSeqNumFlag = true;
        return this;
    }

    public boolean resetSeqNumFlag()
    {
        return resetSeqNumFlag;
    }

    private int nextExpectedMsgSeqNum;

    private boolean hasNextExpectedMsgSeqNum;

    public boolean hasNextExpectedMsgSeqNum()
    {
        return hasNextExpectedMsgSeqNum;
    }

    public LogonEncoder nextExpectedMsgSeqNum(int value)
    {
        nextExpectedMsgSeqNum = value;
        hasNextExpectedMsgSeqNum = true;
        return this;
    }

    public int nextExpectedMsgSeqNum()
    {
        return nextExpectedMsgSeqNum;
    }

    private int maxMessageSize;

    private boolean hasMaxMessageSize;

    public boolean hasMaxMessageSize()
    {
        return hasMaxMessageSize;
    }

    public LogonEncoder maxMessageSize(int value)
    {
        maxMessageSize = value;
        hasMaxMessageSize = true;
        return this;
    }

    public int maxMessageSize()
    {
        return maxMessageSize;
    }

    private boolean testMessageIndicator;

    private boolean hasTestMessageIndicator;

    public boolean hasTestMessageIndicator()
    {
        return hasTestMessageIndicator;
    }

    public LogonEncoder testMessageIndicator(boolean value)
    {
        testMessageIndicator = value;
        hasTestMessageIndicator = true;
        return this;
    }

    public boolean testMessageIndicator()
    {
        return testMessageIndicator;
    }

    private final MutableDirectBuffer username = new UnsafeBuffer();

    private int usernameOffset = 0;

    private int usernameLength = 0;

    public LogonEncoder username(final DirectBuffer value, final int offset, final int length)
    {
        username.wrap(value);
        usernameOffset = offset;
        usernameLength = length;
        return this;
    }

    public LogonEncoder username(final DirectBuffer value, final int length)
    {
        return username(value, 0, length);
    }

    public LogonEncoder username(final DirectBuffer value)
    {
        return username(value, 0, value.capacity());
    }

    public LogonEncoder username(final byte[] value, final int offset, final int length)
    {
        username.wrap(value);
        usernameOffset = offset;
        usernameLength = length;
        return this;
    }

    public LogonEncoder usernameAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(username, value, offset, length);
        usernameOffset = offset;
        usernameLength = length;
        return this;
    }

    public LogonEncoder username(final byte[] value, final int length)
    {
        return username(value, 0, length);
    }

    public LogonEncoder username(final byte[] value)
    {
        return username(value, 0, value.length);
    }

    public boolean hasUsername()
    {
        return usernameLength > 0;
    }

    public MutableDirectBuffer username()
    {
        return username;
    }

    public String usernameAsString()
    {
        return username.getStringWithoutLengthAscii(usernameOffset, usernameLength);
    }

    public LogonEncoder username(final CharSequence value)
    {
        toBytes(value, username);
        usernameOffset = 0;
        usernameLength = value.length();
        return this;
    }

    public LogonEncoder username(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            username.wrap(buffer);
            usernameOffset = value.offset();
            usernameLength = value.length();
        }
        return this;
    }

    public LogonEncoder username(final char[] value)
    {
        return username(value, 0, value.length);
    }

    public LogonEncoder username(final char[] value, final int length)
    {
        return username(value, 0, length);
    }

    public LogonEncoder username(final char[] value, final int offset, final int length)
    {
        toBytes(value, username, offset, length);
        usernameOffset = 0;
        usernameLength = length;
        return this;
    }

    private final MutableDirectBuffer password = new UnsafeBuffer();

    private int passwordOffset = 0;

    private int passwordLength = 0;

    public LogonEncoder password(final DirectBuffer value, final int offset, final int length)
    {
        password.wrap(value);
        passwordOffset = offset;
        passwordLength = length;
        return this;
    }

    public LogonEncoder password(final DirectBuffer value, final int length)
    {
        return password(value, 0, length);
    }

    public LogonEncoder password(final DirectBuffer value)
    {
        return password(value, 0, value.capacity());
    }

    public LogonEncoder password(final byte[] value, final int offset, final int length)
    {
        password.wrap(value);
        passwordOffset = offset;
        passwordLength = length;
        return this;
    }

    public LogonEncoder passwordAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(password, value, offset, length);
        passwordOffset = offset;
        passwordLength = length;
        return this;
    }

    public LogonEncoder password(final byte[] value, final int length)
    {
        return password(value, 0, length);
    }

    public LogonEncoder password(final byte[] value)
    {
        return password(value, 0, value.length);
    }

    public boolean hasPassword()
    {
        return passwordLength > 0;
    }

    public MutableDirectBuffer password()
    {
        return password;
    }

    public String passwordAsString()
    {
        return password.getStringWithoutLengthAscii(passwordOffset, passwordLength);
    }

    public LogonEncoder password(final CharSequence value)
    {
        toBytes(value, password);
        passwordOffset = 0;
        passwordLength = value.length();
        return this;
    }

    public LogonEncoder password(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            password.wrap(buffer);
            passwordOffset = value.offset();
            passwordLength = value.length();
        }
        return this;
    }

    public LogonEncoder password(final char[] value)
    {
        return password(value, 0, value.length);
    }

    public LogonEncoder password(final char[] value, final int length)
    {
        return password(value, 0, length);
    }

    public LogonEncoder password(final char[] value, final int offset, final int length)
    {
        toBytes(value, password, offset, length);
        passwordOffset = 0;
        passwordLength = length;
        return this;
    }

    private final MutableDirectBuffer defaultApplVerID = new UnsafeBuffer();

    private int defaultApplVerIDOffset = 0;

    private int defaultApplVerIDLength = 0;

    public LogonEncoder defaultApplVerID(final DirectBuffer value, final int offset, final int length)
    {
        defaultApplVerID.wrap(value);
        defaultApplVerIDOffset = offset;
        defaultApplVerIDLength = length;
        return this;
    }

    public LogonEncoder defaultApplVerID(final DirectBuffer value, final int length)
    {
        return defaultApplVerID(value, 0, length);
    }

    public LogonEncoder defaultApplVerID(final DirectBuffer value)
    {
        return defaultApplVerID(value, 0, value.capacity());
    }

    public LogonEncoder defaultApplVerID(final byte[] value, final int offset, final int length)
    {
        defaultApplVerID.wrap(value);
        defaultApplVerIDOffset = offset;
        defaultApplVerIDLength = length;
        return this;
    }

    public LogonEncoder defaultApplVerIDAsCopy(final byte[] value, final int offset, final int length)
    {
        copyInto(defaultApplVerID, value, offset, length);
        defaultApplVerIDOffset = offset;
        defaultApplVerIDLength = length;
        return this;
    }

    public LogonEncoder defaultApplVerID(final byte[] value, final int length)
    {
        return defaultApplVerID(value, 0, length);
    }

    public LogonEncoder defaultApplVerID(final byte[] value)
    {
        return defaultApplVerID(value, 0, value.length);
    }

    public boolean hasDefaultApplVerID()
    {
        return defaultApplVerIDLength > 0;
    }

    public MutableDirectBuffer defaultApplVerID()
    {
        return defaultApplVerID;
    }

    public String defaultApplVerIDAsString()
    {
        return defaultApplVerID.getStringWithoutLengthAscii(defaultApplVerIDOffset, defaultApplVerIDLength);
    }

    public LogonEncoder defaultApplVerID(final CharSequence value)
    {
        toBytes(value, defaultApplVerID);
        defaultApplVerIDOffset = 0;
        defaultApplVerIDLength = value.length();
        return this;
    }

    public LogonEncoder defaultApplVerID(final AsciiSequenceView value)
    {
        final DirectBuffer buffer = value.buffer();
        if (buffer != null)
        {
            defaultApplVerID.wrap(buffer);
            defaultApplVerIDOffset = value.offset();
            defaultApplVerIDLength = value.length();
        }
        return this;
    }

    public LogonEncoder defaultApplVerID(final char[] value)
    {
        return defaultApplVerID(value, 0, value.length);
    }

    public LogonEncoder defaultApplVerID(final char[] value, final int length)
    {
        return defaultApplVerID(value, 0, length);
    }

    public LogonEncoder defaultApplVerID(final char[] value, final int offset, final int length)
    {
        toBytes(value, defaultApplVerID, offset, length);
        defaultApplVerIDOffset = 0;
        defaultApplVerIDLength = length;
        return this;
    }

    private final MsgTypeGrpEncoder msgTypeGrp = new MsgTypeGrpEncoder();
    public MsgTypeGrpEncoder msgTypeGrp()
    {
        return msgTypeGrp;
    }

    public LogonEncoder cancelOnDisconnectType(final int value)
    {
        throw new UnsupportedOperationException();
    }
    public LogonEncoder cODTimeoutWindow(final int value)
    {
        throw new UnsupportedOperationException();
    }
    public boolean supportsUsername()
    {
        return true;
    }

    public boolean supportsPassword()
    {
        return true;
    }

    public boolean supportsCancelOnDisconnectType()
    {
        return false;
    }

    public boolean supportsCODTimeoutWindow()
    {
        return false;
    }

    public long encode(final MutableAsciiBuffer buffer, final int offset)
    {
        final long startMessageResult = header.startMessage(buffer, offset);
        final int bodyStart = Encoder.offset(startMessageResult);
        int position = bodyStart + Encoder.length(startMessageResult);

        if (hasEncryptMethod)
        {
            buffer.putBytes(position, encryptMethodHeader, 0, encryptMethodHeaderLength);
            position += encryptMethodHeaderLength;
            position += buffer.putIntAscii(position, encryptMethod);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: EncryptMethod");
        }

        if (hasHeartBtInt)
        {
            buffer.putBytes(position, heartBtIntHeader, 0, heartBtIntHeaderLength);
            position += heartBtIntHeaderLength;
            position += buffer.putIntAscii(position, heartBtInt);
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: HeartBtInt");
        }

        if (hasRawDataLength)
        {
            buffer.putBytes(position, rawDataLengthHeader, 0, rawDataLengthHeaderLength);
            position += rawDataLengthHeaderLength;
            position += buffer.putIntAscii(position, rawDataLength);
            buffer.putSeparator(position);
            position++;
        }

        if (hasRawData)
        {
            buffer.putBytes(position, rawDataHeader, 0, rawDataHeaderLength);
            position += rawDataHeaderLength;
            buffer.putBytes(position, rawData);
            position += rawData.length;
            buffer.putSeparator(position);
            position++;
        }

        if (hasResetSeqNumFlag)
        {
            buffer.putBytes(position, resetSeqNumFlagHeader, 0, resetSeqNumFlagHeaderLength);
            position += resetSeqNumFlagHeaderLength;
            position += buffer.putBooleanAscii(position, resetSeqNumFlag);
            buffer.putSeparator(position);
            position++;
        }

        if (hasNextExpectedMsgSeqNum)
        {
            buffer.putBytes(position, nextExpectedMsgSeqNumHeader, 0, nextExpectedMsgSeqNumHeaderLength);
            position += nextExpectedMsgSeqNumHeaderLength;
            position += buffer.putIntAscii(position, nextExpectedMsgSeqNum);
            buffer.putSeparator(position);
            position++;
        }

        if (hasMaxMessageSize)
        {
            buffer.putBytes(position, maxMessageSizeHeader, 0, maxMessageSizeHeaderLength);
            position += maxMessageSizeHeaderLength;
            position += buffer.putIntAscii(position, maxMessageSize);
            buffer.putSeparator(position);
            position++;
        }

        if (hasTestMessageIndicator)
        {
            buffer.putBytes(position, testMessageIndicatorHeader, 0, testMessageIndicatorHeaderLength);
            position += testMessageIndicatorHeaderLength;
            position += buffer.putBooleanAscii(position, testMessageIndicator);
            buffer.putSeparator(position);
            position++;
        }

        if (usernameLength > 0)
        {
            buffer.putBytes(position, usernameHeader, 0, usernameHeaderLength);
            position += usernameHeaderLength;
            buffer.putBytes(position, username, usernameOffset, usernameLength);
            position += usernameLength;
            buffer.putSeparator(position);
            position++;
        }

        if (passwordLength > 0)
        {
            buffer.putBytes(position, passwordHeader, 0, passwordHeaderLength);
            position += passwordHeaderLength;
            buffer.putBytes(position, password, passwordOffset, passwordLength);
            position += passwordLength;
            buffer.putSeparator(position);
            position++;
        }

        if (defaultApplVerIDLength > 0)
        {
            buffer.putBytes(position, defaultApplVerIDHeader, 0, defaultApplVerIDHeaderLength);
            position += defaultApplVerIDHeaderLength;
            buffer.putBytes(position, defaultApplVerID, defaultApplVerIDOffset, defaultApplVerIDLength);
            position += defaultApplVerIDLength;
            buffer.putSeparator(position);
            position++;
        }
        else if (CODEC_VALIDATION_ENABLED)
        {
            throw new EncodingException("Missing Field: DefaultApplVerID");
        }

            position += msgTypeGrp.encode(buffer, position);
        position += trailer.startTrailer(buffer, position);

        final int messageStart = header.finishHeader(buffer, bodyStart, position - bodyStart);
        return trailer.finishMessage(buffer, messageStart, position);
    }

    public void reset()
    {
        header.reset();
        trailer.reset();
        resetMessage();
    }

    public void resetMessage()
    {
        resetEncryptMethod();
        resetHeartBtInt();
        resetRawDataLength();
        resetRawData();
        resetResetSeqNumFlag();
        resetNextExpectedMsgSeqNum();
        resetMaxMessageSize();
        resetTestMessageIndicator();
        resetUsername();
        resetPassword();
        resetDefaultApplVerID();
        msgTypeGrp.reset();
    }

    public void resetEncryptMethod()
    {
        hasEncryptMethod = false;
    }

    public void resetHeartBtInt()
    {
        hasHeartBtInt = false;
    }

    public void resetRawDataLength()
    {
        hasRawDataLength = false;
    }

    public void resetRawData()
    {
        hasRawData = false;
    }

    public void resetResetSeqNumFlag()
    {
        hasResetSeqNumFlag = false;
    }

    public void resetNextExpectedMsgSeqNum()
    {
        hasNextExpectedMsgSeqNum = false;
    }

    public void resetMaxMessageSize()
    {
        hasMaxMessageSize = false;
    }

    public void resetTestMessageIndicator()
    {
        hasTestMessageIndicator = false;
    }

    public void resetUsername()
    {
        usernameLength = 0;
    }

    public void resetPassword()
    {
        passwordLength = 0;
    }

    public void resetDefaultApplVerID()
    {
        defaultApplVerIDLength = 0;
    }

    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        return appendTo(builder, 1);
    }

    public StringBuilder appendTo(final StringBuilder builder, final int level)
    {
        builder.append("{\n");        indent(builder, level);
        builder.append("\"MessageName\": \"Logon\",\n");
        builder.append("  \"header\": ");
        header.appendTo(builder, level + 1);
        builder.append("\n");
        if (hasEncryptMethod())
        {
            indent(builder, level);
            builder.append("\"EncryptMethod\": \"");
            builder.append(encryptMethod);
            builder.append("\",\n");
        }

        if (hasHeartBtInt())
        {
            indent(builder, level);
            builder.append("\"HeartBtInt\": \"");
            builder.append(heartBtInt);
            builder.append("\",\n");
        }

        if (hasRawDataLength())
        {
            indent(builder, level);
            builder.append("\"RawDataLength\": \"");
            builder.append(rawDataLength);
            builder.append("\",\n");
        }

        if (hasRawData())
        {
            indent(builder, level);
            builder.append("\"RawData\": \"");
            appendData(builder, rawData, rawDataLength);
            builder.append("\",\n");
        }

        if (hasResetSeqNumFlag())
        {
            indent(builder, level);
            builder.append("\"ResetSeqNumFlag\": \"");
            builder.append(resetSeqNumFlag);
            builder.append("\",\n");
        }

        if (hasNextExpectedMsgSeqNum())
        {
            indent(builder, level);
            builder.append("\"NextExpectedMsgSeqNum\": \"");
            builder.append(nextExpectedMsgSeqNum);
            builder.append("\",\n");
        }

        if (hasMaxMessageSize())
        {
            indent(builder, level);
            builder.append("\"MaxMessageSize\": \"");
            builder.append(maxMessageSize);
            builder.append("\",\n");
        }

        if (hasTestMessageIndicator())
        {
            indent(builder, level);
            builder.append("\"TestMessageIndicator\": \"");
            builder.append(testMessageIndicator);
            builder.append("\",\n");
        }

        if (hasUsername())
        {
            indent(builder, level);
            builder.append("\"Username\": \"");
            appendBuffer(builder, username, usernameOffset, usernameLength);
            builder.append("\",\n");
        }

        if (hasPassword())
        {
            indent(builder, level);
            builder.append("\"Password\": \"");
            appendBuffer(builder, password, passwordOffset, passwordLength);
            builder.append("\",\n");
        }

        if (hasDefaultApplVerID())
        {
            indent(builder, level);
            builder.append("\"DefaultApplVerID\": \"");
            appendBuffer(builder, defaultApplVerID, defaultApplVerIDOffset, defaultApplVerIDLength);
            builder.append("\",\n");
        }

    indent(builder, level);
    builder.append("\"MsgTypeGrp\": ");
    msgTypeGrp.appendTo(builder, level + 1);
    builder.append("\n");
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public LogonEncoder copyTo(final Encoder encoder)
    {
        return copyTo((LogonEncoder)encoder);
    }

    public LogonEncoder copyTo(final LogonEncoder encoder)
    {
        encoder.reset();
        if (hasEncryptMethod())
        {
            encoder.encryptMethod(encryptMethod());
        }

        if (hasHeartBtInt())
        {
            encoder.heartBtInt(heartBtInt());
        }

        if (hasRawDataLength())
        {
            encoder.rawDataLength(rawDataLength());
        }

        if (hasRawData())
        {
            encoder.rawDataAsCopy(rawData(), 0, rawDataLength());
            encoder.rawDataLength(rawDataLength());
        }

        if (hasResetSeqNumFlag())
        {
            encoder.resetSeqNumFlag(resetSeqNumFlag());
        }

        if (hasNextExpectedMsgSeqNum())
        {
            encoder.nextExpectedMsgSeqNum(nextExpectedMsgSeqNum());
        }

        if (hasMaxMessageSize())
        {
            encoder.maxMessageSize(maxMessageSize());
        }

        if (hasTestMessageIndicator())
        {
            encoder.testMessageIndicator(testMessageIndicator());
        }

        if (hasUsername())
        {
            encoder.usernameAsCopy(username.byteArray(), 0, usernameLength);
        }

        if (hasPassword())
        {
            encoder.passwordAsCopy(password.byteArray(), 0, passwordLength);
        }

        if (hasDefaultApplVerID())
        {
            encoder.defaultApplVerIDAsCopy(defaultApplVerID.byteArray(), 0, defaultApplVerIDLength);
        }


        msgTypeGrp.copyTo(encoder.msgTypeGrp());        return encoder;
    }

}
