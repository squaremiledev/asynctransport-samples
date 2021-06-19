/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;

import uk.co.real_logic.artio.decoder.AbstractLogonDecoder;
import org.agrona.AsciiNumberFormatException;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Decoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.HeaderDecoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder.TrailerDecoder;
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
import uk.co.real_logic.artio.builder.Encoder;
import uk.co.real_logic.artio.builder.CommonDecoderImpl;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static uk.co.real_logic.artio.builder.Validation.CODEC_VALIDATION_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownField.CODEC_REJECT_UNKNOWN_FIELD_ENABLED;
import static uk.co.real_logic.artio.builder.RejectUnknownEnumValue.CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.*;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.LogonEncoder;
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.MsgTypeGrpEncoder;
import static dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.MsgTypeGrpEncoder.MsgTypesGroupEncoder;


public class LogonDecoder extends CommonDecoderImpl implements MsgTypeGrpDecoder, MessageDecoder, AbstractLogonDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(6);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.ENCRYPT_METHOD);
            REQUIRED_FIELDS.add(Constants.HEART_BT_INT);
            REQUIRED_FIELDS.add(Constants.DEFAULT_APPL_VER_ID);
        }
    }

    public final IntHashSet GROUP_FIELDS = new IntHashSet(22);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            GROUP_FIELDS.add(Constants.ENCRYPT_METHOD);
            GROUP_FIELDS.add(Constants.HEART_BT_INT);
            GROUP_FIELDS.add(Constants.RAW_DATA_LENGTH);
            GROUP_FIELDS.add(Constants.RAW_DATA);
            GROUP_FIELDS.add(Constants.RESET_SEQ_NUM_FLAG);
            GROUP_FIELDS.add(Constants.NEXT_EXPECTED_MSG_SEQ_NUM);
            GROUP_FIELDS.add(Constants.MAX_MESSAGE_SIZE);
            GROUP_FIELDS.add(Constants.TEST_MESSAGE_INDICATOR);
            GROUP_FIELDS.add(Constants.USERNAME);
            GROUP_FIELDS.add(Constants.PASSWORD);
            GROUP_FIELDS.add(Constants.DEFAULT_APPL_VER_ID);
        }
    }

    private final IntHashSet alreadyVisitedFields = new IntHashSet(22);

    private final IntHashSet unknownFields = new IntHashSet(10);

    private final IntHashSet missingRequiredFields = new IntHashSet(6);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        final IntIterator unknownFieldsIterator = unknownFields.iterator();
        if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED && unknownFieldsIterator.hasNext())
        {
            invalidTagId = unknownFieldsIterator.nextValue();
            rejectReason = Constants.ALL_FIELDS.contains(invalidTagId) ? 2 : 0;
            return false;
        }
        if (!header.validate())
        {
            invalidTagId = header.invalidTagId();
            rejectReason = header.rejectReason();
            return false;
        }
        else if (!trailer.validate())
        {
            invalidTagId = trailer.invalidTagId();
            rejectReason = trailer.rejectReason();
            return false;
        }
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !EncryptMethod.isValid(encryptMethod()))
        {
            invalidTagId = 98;
            rejectReason = 5;
            return false;
        }
        if (hasNoMsgTypesGroupCounter)
        {
            {
                int count = 0;
                final MsgTypesGroupIterator iterator = msgTypesGroupIterator.iterator();
                for (final MsgTypesGroupDecoder group : iterator)
                {
                    count++;                    if (!group.validate())
                    {
                        invalidTagId = group.invalidTagId();
                        rejectReason = group.rejectReason();
                        return false;
                    }
                }
                if (count != iterator.numberFieldValue())
                {
                    invalidTagId = 384;
                    rejectReason = 16;
                    return false;
                }
            }
        }
        return true;
    }

    public static final long MESSAGE_TYPE = 65L;

    public static final String MESSAGE_TYPE_AS_STRING = "A";

    public static final char[] MESSAGE_TYPE_CHARS = MESSAGE_TYPE_AS_STRING.toCharArray();

    public static final byte[] MESSAGE_TYPE_BYTES = MESSAGE_TYPE_AS_STRING.getBytes(US_ASCII);

    public final IntHashSet messageFields = new IntHashSet(94);

    {
        messageFields.add(Constants.BEGIN_STRING);
        messageFields.add(Constants.BODY_LENGTH);
        messageFields.add(Constants.MSG_TYPE);
        messageFields.add(Constants.SENDER_COMP_ID);
        messageFields.add(Constants.TARGET_COMP_ID);
        messageFields.add(Constants.ON_BEHALF_OF_COMP_ID);
        messageFields.add(Constants.DELIVER_TO_COMP_ID);
        messageFields.add(Constants.SECURE_DATA_LEN);
        messageFields.add(Constants.SECURE_DATA);
        messageFields.add(Constants.MSG_SEQ_NUM);
        messageFields.add(Constants.SENDER_SUB_ID);
        messageFields.add(Constants.SENDER_LOCATION_ID);
        messageFields.add(Constants.TARGET_SUB_ID);
        messageFields.add(Constants.TARGET_LOCATION_ID);
        messageFields.add(Constants.ON_BEHALF_OF_SUB_ID);
        messageFields.add(Constants.ON_BEHALF_OF_LOCATION_ID);
        messageFields.add(Constants.DELIVER_TO_SUB_ID);
        messageFields.add(Constants.DELIVER_TO_LOCATION_ID);
        messageFields.add(Constants.POSS_DUP_FLAG);
        messageFields.add(Constants.POSS_RESEND);
        messageFields.add(Constants.SENDING_TIME);
        messageFields.add(Constants.ORIG_SENDING_TIME);
        messageFields.add(Constants.XML_DATA_LEN);
        messageFields.add(Constants.XML_DATA);
        messageFields.add(Constants.MESSAGE_ENCODING);
        messageFields.add(Constants.LAST_MSG_SEQ_NUM_PROCESSED);
        messageFields.add(Constants.APPL_VER_ID);
        messageFields.add(Constants.CSTM_APPL_VER_ID);
        messageFields.add(Constants.ENCRYPT_METHOD);
        messageFields.add(Constants.HEART_BT_INT);
        messageFields.add(Constants.RAW_DATA_LENGTH);
        messageFields.add(Constants.RAW_DATA);
        messageFields.add(Constants.RESET_SEQ_NUM_FLAG);
        messageFields.add(Constants.NEXT_EXPECTED_MSG_SEQ_NUM);
        messageFields.add(Constants.MAX_MESSAGE_SIZE);
        messageFields.add(Constants.TEST_MESSAGE_INDICATOR);
        messageFields.add(Constants.USERNAME);
        messageFields.add(Constants.PASSWORD);
        messageFields.add(Constants.DEFAULT_APPL_VER_ID);
        messageFields.add(Constants.NO_MSG_TYPES);
        messageFields.add(Constants.REF_MSG_TYPE);
        messageFields.add(Constants.MSG_DIRECTION);
        messageFields.add(Constants.REF_APPL_VER_ID);
        messageFields.add(Constants.REF_CSTM_APPL_VER_ID);
        messageFields.add(Constants.SIGNATURE_LENGTH);
        messageFields.add(Constants.SIGNATURE);
        messageFields.add(Constants.CHECK_SUM);
    }

    private final TrailerDecoder trailer = new TrailerDecoder();

    public TrailerDecoder trailer()
    {
        return trailer;
    }

    private final HeaderDecoder header = new HeaderDecoder(trailer);

    public HeaderDecoder header()
    {
        return header;
    }

    private int encryptMethod = MISSING_INT;

    public int encryptMethod()
    {
        return encryptMethod;
    }



    private final CharArrayWrapper encryptMethodWrapper = new CharArrayWrapper();
    public EncryptMethod encryptMethodAsEnum()
    {
        return EncryptMethod.decode(encryptMethod);
    }

    private int heartBtInt = MISSING_INT;

    public int heartBtInt()
    {
        return heartBtInt;
    }



    private int rawDataLength = MISSING_INT;

    private boolean hasRawDataLength;

    public int rawDataLength()
    {
        if (!hasRawDataLength)
        {
            throw new IllegalArgumentException("No value for optional field: RawDataLength");
        }

        return rawDataLength;
    }

    public boolean hasRawDataLength()
    {
        return hasRawDataLength;
    }



    private byte[] rawData = new byte[1];

    private boolean hasRawData;

    public byte[] rawData()
    {
        if (!hasRawData)
        {
            throw new IllegalArgumentException("No value for optional field: RawData");
        }

        return rawData;
    }

    public boolean hasRawData()
    {
        return hasRawData;
    }



    private boolean resetSeqNumFlag;

    private boolean hasResetSeqNumFlag;

    public boolean resetSeqNumFlag()
    {
        if (!hasResetSeqNumFlag)
        {
            throw new IllegalArgumentException("No value for optional field: ResetSeqNumFlag");
        }

        return resetSeqNumFlag;
    }

    public boolean hasResetSeqNumFlag()
    {
        return hasResetSeqNumFlag;
    }



    private int nextExpectedMsgSeqNum = MISSING_INT;

    private boolean hasNextExpectedMsgSeqNum;

    public int nextExpectedMsgSeqNum()
    {
        if (!hasNextExpectedMsgSeqNum)
        {
            throw new IllegalArgumentException("No value for optional field: NextExpectedMsgSeqNum");
        }

        return nextExpectedMsgSeqNum;
    }

    public boolean hasNextExpectedMsgSeqNum()
    {
        return hasNextExpectedMsgSeqNum;
    }



    private int maxMessageSize = MISSING_INT;

    private boolean hasMaxMessageSize;

    public int maxMessageSize()
    {
        if (!hasMaxMessageSize)
        {
            throw new IllegalArgumentException("No value for optional field: MaxMessageSize");
        }

        return maxMessageSize;
    }

    public boolean hasMaxMessageSize()
    {
        return hasMaxMessageSize;
    }



    private boolean testMessageIndicator;

    private boolean hasTestMessageIndicator;

    public boolean testMessageIndicator()
    {
        if (!hasTestMessageIndicator)
        {
            throw new IllegalArgumentException("No value for optional field: TestMessageIndicator");
        }

        return testMessageIndicator;
    }

    public boolean hasTestMessageIndicator()
    {
        return hasTestMessageIndicator;
    }



    private char[] username = new char[1];

    private boolean hasUsername;

    public char[] username()
    {
        if (!hasUsername)
        {
            throw new IllegalArgumentException("No value for optional field: Username");
        }

        return username;
    }

    public boolean hasUsername()
    {
        return hasUsername;
    }


    private int usernameOffset;

    private int usernameLength;

    public int usernameLength()
    {
        if (!hasUsername)
        {
            throw new IllegalArgumentException("No value for optional field: Username");
        }

        return usernameLength;
    }

    public String usernameAsString()
    {
        return hasUsername ? new String(username, 0, usernameLength) : null;
    }

    public void username(final AsciiSequenceView view)
    {
        if (!hasUsername)
        {
            throw new IllegalArgumentException("No value for optional field: Username");
        }

        view.wrap(buffer, usernameOffset, usernameLength);
    }


    private char[] password = new char[1];

    private boolean hasPassword;

    public char[] password()
    {
        if (!hasPassword)
        {
            throw new IllegalArgumentException("No value for optional field: Password");
        }

        return password;
    }

    public boolean hasPassword()
    {
        return hasPassword;
    }


    private int passwordOffset;

    private int passwordLength;

    public int passwordLength()
    {
        if (!hasPassword)
        {
            throw new IllegalArgumentException("No value for optional field: Password");
        }

        return passwordLength;
    }

    public String passwordAsString()
    {
        return hasPassword ? new String(password, 0, passwordLength) : null;
    }

    public void password(final AsciiSequenceView view)
    {
        if (!hasPassword)
        {
            throw new IllegalArgumentException("No value for optional field: Password");
        }

        view.wrap(buffer, passwordOffset, passwordLength);
    }


    private char[] defaultApplVerID = new char[1];

    public char[] defaultApplVerID()
    {
        return defaultApplVerID;
    }


    private int defaultApplVerIDOffset;

    private int defaultApplVerIDLength;

    public int defaultApplVerIDLength()
    {
        return defaultApplVerIDLength;
    }

    public String defaultApplVerIDAsString()
    {
        return new String(defaultApplVerID, 0, defaultApplVerIDLength);
    }

    public void defaultApplVerID(final AsciiSequenceView view)
    {
        view.wrap(buffer, defaultApplVerIDOffset, defaultApplVerIDLength);
    }




    private MsgTypesGroupDecoder msgTypesGroup = null;
    public MsgTypesGroupDecoder msgTypesGroup()
    {
        return msgTypesGroup;
    }

    private int noMsgTypesGroupCounter = MISSING_INT;

    private boolean hasNoMsgTypesGroupCounter;

    public int noMsgTypesGroupCounter()
    {
        if (!hasNoMsgTypesGroupCounter)
        {
            throw new IllegalArgumentException("No value for optional field: NoMsgTypesGroupCounter");
        }

        return noMsgTypesGroupCounter;
    }

    public boolean hasNoMsgTypesGroupCounter()
    {
        return hasNoMsgTypesGroupCounter;
    }




    private MsgTypesGroupIterator msgTypesGroupIterator = new MsgTypesGroupIterator(this);
    public MsgTypesGroupIterator msgTypesGroupIterator()
    {
        return msgTypesGroupIterator.iterator();
    }


    public int cancelOnDisconnectType()
    {
        throw new UnsupportedOperationException();
    }

    public boolean hasCancelOnDisconnectType()
    {
        throw new UnsupportedOperationException();
    }

    public int cODTimeoutWindow()
    {
        throw new UnsupportedOperationException();
    }

    public boolean hasCODTimeoutWindow()
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

    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode Logon
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
            alreadyVisitedFields.clear();
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
        position += header.decode(buffer, position, length);
        int tag;

        while (position < end)
        {
            final int equalsPosition = buffer.scan(position, end, '=');
            if (equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
               return position;
            }
            tag = buffer.getInt(position, equalsPosition);
            final int valueOffset = equalsPosition + 1;
            int endOfField = buffer.scan(valueOffset, end, START_OF_HEADER);
            if (endOfField == AsciiBuffer.UNKNOWN_INDEX || equalsPosition == AsciiBuffer.UNKNOWN_INDEX)
            {
                rejectReason = 5;
                break;
            }
            final int valueLength = endOfField - valueOffset;
            if (CODEC_VALIDATION_ENABLED)
            {
                if (tag <= 0)
                {
                    invalidTagId = tag;
                    rejectReason = 0;
                }
                else if (valueLength == 0)
                {
                    invalidTagId = tag;
                    rejectReason = 4;
                }
                if (!alreadyVisitedFields.add(tag))
                {
                    invalidTagId = tag;
                    rejectReason = 13;
                }
                missingRequiredFields.remove(tag);
                seenFieldCount++;
            }

            switch (tag)
            {
            case Constants.ENCRYPT_METHOD:
                encryptMethod = getInt(buffer, valueOffset, endOfField, 98, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.HEART_BT_INT:
                heartBtInt = getInt(buffer, valueOffset, endOfField, 108, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.RAW_DATA_LENGTH:
                hasRawDataLength = true;
                rawDataLength = getInt(buffer, valueOffset, endOfField, 95, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.RAW_DATA:
                hasRawData = true;
                rawData = buffer.getBytes(rawData, valueOffset, rawDataLength);
                endOfField = valueOffset + rawDataLength;
                break;

            case Constants.RESET_SEQ_NUM_FLAG:
                hasResetSeqNumFlag = true;
                resetSeqNumFlag = buffer.getBoolean(valueOffset);
                break;

            case Constants.NEXT_EXPECTED_MSG_SEQ_NUM:
                hasNextExpectedMsgSeqNum = true;
                nextExpectedMsgSeqNum = getInt(buffer, valueOffset, endOfField, 789, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.MAX_MESSAGE_SIZE:
                hasMaxMessageSize = true;
                maxMessageSize = getInt(buffer, valueOffset, endOfField, 383, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.TEST_MESSAGE_INDICATOR:
                hasTestMessageIndicator = true;
                testMessageIndicator = buffer.getBoolean(valueOffset);
                break;

            case Constants.USERNAME:
                hasUsername = true;
                username = buffer.getChars(username, valueOffset, valueLength);
                usernameOffset = valueOffset;
                usernameLength = valueLength;
                break;

            case Constants.PASSWORD:
                hasPassword = true;
                password = buffer.getChars(password, valueOffset, valueLength);
                passwordOffset = valueOffset;
                passwordLength = valueLength;
                break;

            case Constants.DEFAULT_APPL_VER_ID:
                defaultApplVerID = buffer.getChars(defaultApplVerID, valueOffset, valueLength);
                defaultApplVerIDOffset = valueOffset;
                defaultApplVerIDLength = valueLength;
                break;

            case Constants.NO_MSG_TYPES:
                hasNoMsgTypesGroupCounter = true;
                noMsgTypesGroupCounter = getInt(buffer, valueOffset, endOfField, 384, CODEC_VALIDATION_ENABLED);
                if (msgTypesGroup == null)
                {
                    msgTypesGroup = new MsgTypesGroupDecoder(trailer, messageFields);
                }
                MsgTypesGroupDecoder msgTypesGroupCurrent = msgTypesGroup;
                position = endOfField + 1;
                final int noMsgTypesGroupCounter = this.noMsgTypesGroupCounter;
                for (int i = 0; i < noMsgTypesGroupCounter && position < end; i++)
                {
                    if (msgTypesGroupCurrent != null)
                    {
                        position += msgTypesGroupCurrent.decode(buffer, position, end - position);
                        msgTypesGroupCurrent = msgTypesGroupCurrent.next();
                    }
                }
                if (CODEC_VALIDATION_ENABLED)
                {
                    final int checkEqualsPosition = buffer.scan(position, end, '=');
                    if (checkEqualsPosition != AsciiBuffer.UNKNOWN_INDEX)
                    {
                        final int checkTag = buffer.getInt(position, checkEqualsPosition);
                        if (msgTypesGroup.ALL_GROUP_FIELDS.contains(checkTag))
                        {
                            invalidTagId = tag;
                            rejectReason = 16;
                            return position;
                        }
                    }
                }
                break;


            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    alreadyVisitedFields.remove(tag);
                }
                else
                {
                    if (!(trailer.REQUIRED_FIELDS.contains(tag)))
                    {
                        unknownFields.add(tag);
                    }
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || (trailer.REQUIRED_FIELDS.contains(tag)))
                {
                    position += trailer.decode(buffer, position, end - position);
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        position += trailer.decode(buffer, position, end - position);
        return position - offset;
    }

    public void reset()
    {
        header.reset();
        trailer.reset();
        resetMessage();
        buffer = null;
        if (CODEC_VALIDATION_ENABLED)
        {
            invalidTagId = Decoder.NO_ERROR;
            rejectReason = Decoder.NO_ERROR;
            missingRequiredFields.clear();
            unknownFields.clear();
            alreadyVisitedFields.clear();
        }
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
        resetMsgTypesGroup();
    }

    public void resetEncryptMethod()
    {
        encryptMethod = MISSING_INT;
    }

    public void resetHeartBtInt()
    {
        heartBtInt = MISSING_INT;
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
        hasUsername = false;
    }

    public void resetPassword()
    {
        hasPassword = false;
    }

    public void resetDefaultApplVerID()
    {
        defaultApplVerIDOffset = 0;
        defaultApplVerIDLength = 0;
    }

    public void resetMsgTypesGroup()
    {
        for (final MsgTypesGroupDecoder msgTypesGroupDecoder : msgTypesGroupIterator.iterator())
        {
            msgTypesGroupDecoder.reset();
            if (msgTypesGroupDecoder.next() == null)
            {
                break;
            }
        }
        noMsgTypesGroupCounter = 0;
        hasNoMsgTypesGroupCounter = false;
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
        indent(builder, level);
        builder.append("\"EncryptMethod\": \"");
        builder.append(encryptMethod);
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"HeartBtInt\": \"");
        builder.append(heartBtInt);
        builder.append("\",\n");

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
            builder.append(username(), 0, usernameLength());
            builder.append("\",\n");
        }

        if (hasPassword())
        {
            indent(builder, level);
            builder.append("\"Password\": \"");
            builder.append(password(), 0, passwordLength());
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"DefaultApplVerID\": \"");
        builder.append(defaultApplVerID(), 0, defaultApplVerIDLength());
        builder.append("\",\n");

    if (hasNoMsgTypesGroupCounter)
    {
        indent(builder, level);
        builder.append("\"MsgTypesGroup\": [\n");
        MsgTypesGroupDecoder msgTypesGroup = this.msgTypesGroup;
        for (int i = 0, size = this.noMsgTypesGroupCounter; i < size; i++)
        {
            indent(builder, level);
            msgTypesGroup.appendTo(builder, level + 1);            if (msgTypesGroup.next() != null)
            {
                builder.append(',');
            }
            builder.append('\n');
            msgTypesGroup = msgTypesGroup.next();        }
        indent(builder, level);
        builder.append("],\n");
    }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public LogonEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((LogonEncoder)encoder);
    }

    public LogonEncoder toEncoder(final LogonEncoder encoder)
    {
        encoder.reset();
        encoder.encryptMethod(encryptMethod());
        encoder.heartBtInt(heartBtInt());
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
            encoder.username(username(), 0, usernameLength());
        }

        if (hasPassword())
        {
            encoder.password(password(), 0, passwordLength());
        }

        encoder.defaultApplVerID(defaultApplVerID(), 0, defaultApplVerIDLength());

        final MsgTypeGrpEncoder msgTypeGrp = encoder.msgTypeGrp();        if (hasNoMsgTypesGroupCounter)
        {
            final int size = this.noMsgTypesGroupCounter;
            MsgTypesGroupDecoder msgTypesGroup = this.msgTypesGroup;
            MsgTypesGroupEncoder msgTypesGroupEncoder = msgTypeGrp.msgTypesGroup(size);
            for (int i = 0; i < size; i++)
            {
                if (msgTypesGroup != null)
                {
                    msgTypesGroup.toEncoder(msgTypesGroupEncoder);
                    msgTypesGroup = msgTypesGroup.next();
                    msgTypesGroupEncoder = msgTypesGroupEncoder.next();
                }
            }
        }

        return encoder;
    }

}
