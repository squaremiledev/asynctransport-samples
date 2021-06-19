/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt.decoder;

import uk.co.real_logic.artio.util.MessageTypeEncoding;
import uk.co.real_logic.artio.decoder.SessionHeaderDecoder;
import org.agrona.AsciiNumberFormatException;
import org.agrona.MutableDirectBuffer;
import org.agrona.AsciiSequenceView;
import static uk.co.real_logic.artio.dictionary.generation.CodecUtil.*;
import static uk.co.real_logic.artio.dictionary.SessionConstants.*;
import uk.co.real_logic.artio.builder.Decoder;
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
import dev.squaremile.asynctransportsamples.fix.messages.fixt.builder.HeaderEncoder;


public class HeaderDecoder extends CommonDecoderImpl implements SessionHeaderDecoder
{
    public final IntHashSet REQUIRED_FIELDS = new IntHashSet(14);

    {
        if (CODEC_VALIDATION_ENABLED)
        {
            REQUIRED_FIELDS.add(Constants.BEGIN_STRING);
            REQUIRED_FIELDS.add(Constants.BODY_LENGTH);
            REQUIRED_FIELDS.add(Constants.MSG_TYPE);
            REQUIRED_FIELDS.add(Constants.SENDER_COMP_ID);
            REQUIRED_FIELDS.add(Constants.TARGET_COMP_ID);
            REQUIRED_FIELDS.add(Constants.MSG_SEQ_NUM);
            REQUIRED_FIELDS.add(Constants.SENDING_TIME);
        }
    }

    private final IntHashSet alreadyVisitedFields = new IntHashSet(56);

    private final IntHashSet unknownFields = new IntHashSet(10);

    private final IntHashSet missingRequiredFields = new IntHashSet(14);

    public boolean validate()
    {
        if (rejectReason != Decoder.NO_ERROR)
        {
            return false;
        }
        final IntIterator missingFieldsIterator = missingRequiredFields.iterator();
        if (missingFieldsIterator.hasNext())
        {
            invalidTagId = missingFieldsIterator.nextValue();
            rejectReason = 1;
            return false;
        }
        msgTypeWrapper.wrap(msgType(), msgTypeLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MsgType.isValid(msgTypeWrapper))
        {
            invalidTagId = 35;
            rejectReason = 5;
            return false;
        }

        if (hasMessageEncoding)
        {
        messageEncodingWrapper.wrap(messageEncoding(), messageEncodingLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !MessageEncoding.isValid(messageEncodingWrapper))
        {
            invalidTagId = 347;
            rejectReason = 5;
            return false;
        }
        }

        if (hasApplVerID)
        {
        applVerIDWrapper.wrap(applVerID(), applVerIDLength);
        if (CODEC_REJECT_UNKNOWN_ENUM_VALUE_ENABLED && !ApplVerID.isValid(applVerIDWrapper))
        {
            invalidTagId = 1128;
            rejectReason = 5;
            return false;
        }
        }
        return true;
    }

    public HeaderDecoder()
    {
        this(new TrailerDecoder());
    }

    private final TrailerDecoder trailer;
    public HeaderDecoder(final TrailerDecoder trailer)
    {
        this.trailer = trailer;
    }

    public long messageType()
    {
        return MessageTypeEncoding.packMessageType(msgType(), msgTypeLength());
    }

    private char[] beginString = new char[1];

    public char[] beginString()
    {
        return beginString;
    }


    private int beginStringOffset;

    private int beginStringLength;

    public int beginStringLength()
    {
        return beginStringLength;
    }

    public String beginStringAsString()
    {
        return new String(beginString, 0, beginStringLength);
    }

    public void beginString(final AsciiSequenceView view)
    {
        view.wrap(buffer, beginStringOffset, beginStringLength);
    }


    private int bodyLength = MISSING_INT;

    public int bodyLength()
    {
        return bodyLength;
    }



    private char[] msgType = new char[1];

    public char[] msgType()
    {
        return msgType;
    }


    private int msgTypeOffset;

    private int msgTypeLength;

    public int msgTypeLength()
    {
        return msgTypeLength;
    }

    public String msgTypeAsString()
    {
        return new String(msgType, 0, msgTypeLength);
    }

    public void msgType(final AsciiSequenceView view)
    {
        view.wrap(buffer, msgTypeOffset, msgTypeLength);
    }


    private final CharArrayWrapper msgTypeWrapper = new CharArrayWrapper();
    public MsgType msgTypeAsEnum()
    {
        msgTypeWrapper.wrap(msgType(), msgTypeLength);
        return MsgType.decode(msgTypeWrapper);
    }

    private char[] senderCompID = new char[1];

    public char[] senderCompID()
    {
        return senderCompID;
    }


    private int senderCompIDOffset;

    private int senderCompIDLength;

    public int senderCompIDLength()
    {
        return senderCompIDLength;
    }

    public String senderCompIDAsString()
    {
        return new String(senderCompID, 0, senderCompIDLength);
    }

    public void senderCompID(final AsciiSequenceView view)
    {
        view.wrap(buffer, senderCompIDOffset, senderCompIDLength);
    }


    private char[] targetCompID = new char[1];

    public char[] targetCompID()
    {
        return targetCompID;
    }


    private int targetCompIDOffset;

    private int targetCompIDLength;

    public int targetCompIDLength()
    {
        return targetCompIDLength;
    }

    public String targetCompIDAsString()
    {
        return new String(targetCompID, 0, targetCompIDLength);
    }

    public void targetCompID(final AsciiSequenceView view)
    {
        view.wrap(buffer, targetCompIDOffset, targetCompIDLength);
    }


    private char[] onBehalfOfCompID = new char[1];

    private boolean hasOnBehalfOfCompID;

    public char[] onBehalfOfCompID()
    {
        if (!hasOnBehalfOfCompID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfCompID");
        }

        return onBehalfOfCompID;
    }

    public boolean hasOnBehalfOfCompID()
    {
        return hasOnBehalfOfCompID;
    }


    private int onBehalfOfCompIDOffset;

    private int onBehalfOfCompIDLength;

    public int onBehalfOfCompIDLength()
    {
        if (!hasOnBehalfOfCompID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfCompID");
        }

        return onBehalfOfCompIDLength;
    }

    public String onBehalfOfCompIDAsString()
    {
        return hasOnBehalfOfCompID ? new String(onBehalfOfCompID, 0, onBehalfOfCompIDLength) : null;
    }

    public void onBehalfOfCompID(final AsciiSequenceView view)
    {
        if (!hasOnBehalfOfCompID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfCompID");
        }

        view.wrap(buffer, onBehalfOfCompIDOffset, onBehalfOfCompIDLength);
    }


    private char[] deliverToCompID = new char[1];

    private boolean hasDeliverToCompID;

    public char[] deliverToCompID()
    {
        if (!hasDeliverToCompID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToCompID");
        }

        return deliverToCompID;
    }

    public boolean hasDeliverToCompID()
    {
        return hasDeliverToCompID;
    }


    private int deliverToCompIDOffset;

    private int deliverToCompIDLength;

    public int deliverToCompIDLength()
    {
        if (!hasDeliverToCompID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToCompID");
        }

        return deliverToCompIDLength;
    }

    public String deliverToCompIDAsString()
    {
        return hasDeliverToCompID ? new String(deliverToCompID, 0, deliverToCompIDLength) : null;
    }

    public void deliverToCompID(final AsciiSequenceView view)
    {
        if (!hasDeliverToCompID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToCompID");
        }

        view.wrap(buffer, deliverToCompIDOffset, deliverToCompIDLength);
    }


    private int secureDataLen = MISSING_INT;

    private boolean hasSecureDataLen;

    public int secureDataLen()
    {
        if (!hasSecureDataLen)
        {
            throw new IllegalArgumentException("No value for optional field: SecureDataLen");
        }

        return secureDataLen;
    }

    public boolean hasSecureDataLen()
    {
        return hasSecureDataLen;
    }



    private byte[] secureData = new byte[1];

    private boolean hasSecureData;

    public byte[] secureData()
    {
        if (!hasSecureData)
        {
            throw new IllegalArgumentException("No value for optional field: SecureData");
        }

        return secureData;
    }

    public boolean hasSecureData()
    {
        return hasSecureData;
    }



    private int msgSeqNum = MISSING_INT;

    public int msgSeqNum()
    {
        return msgSeqNum;
    }



    private char[] senderSubID = new char[1];

    private boolean hasSenderSubID;

    public char[] senderSubID()
    {
        if (!hasSenderSubID)
        {
            throw new IllegalArgumentException("No value for optional field: SenderSubID");
        }

        return senderSubID;
    }

    public boolean hasSenderSubID()
    {
        return hasSenderSubID;
    }


    private int senderSubIDOffset;

    private int senderSubIDLength;

    public int senderSubIDLength()
    {
        if (!hasSenderSubID)
        {
            throw new IllegalArgumentException("No value for optional field: SenderSubID");
        }

        return senderSubIDLength;
    }

    public String senderSubIDAsString()
    {
        return hasSenderSubID ? new String(senderSubID, 0, senderSubIDLength) : null;
    }

    public void senderSubID(final AsciiSequenceView view)
    {
        if (!hasSenderSubID)
        {
            throw new IllegalArgumentException("No value for optional field: SenderSubID");
        }

        view.wrap(buffer, senderSubIDOffset, senderSubIDLength);
    }


    private char[] senderLocationID = new char[1];

    private boolean hasSenderLocationID;

    public char[] senderLocationID()
    {
        if (!hasSenderLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: SenderLocationID");
        }

        return senderLocationID;
    }

    public boolean hasSenderLocationID()
    {
        return hasSenderLocationID;
    }


    private int senderLocationIDOffset;

    private int senderLocationIDLength;

    public int senderLocationIDLength()
    {
        if (!hasSenderLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: SenderLocationID");
        }

        return senderLocationIDLength;
    }

    public String senderLocationIDAsString()
    {
        return hasSenderLocationID ? new String(senderLocationID, 0, senderLocationIDLength) : null;
    }

    public void senderLocationID(final AsciiSequenceView view)
    {
        if (!hasSenderLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: SenderLocationID");
        }

        view.wrap(buffer, senderLocationIDOffset, senderLocationIDLength);
    }


    private char[] targetSubID = new char[1];

    private boolean hasTargetSubID;

    public char[] targetSubID()
    {
        if (!hasTargetSubID)
        {
            throw new IllegalArgumentException("No value for optional field: TargetSubID");
        }

        return targetSubID;
    }

    public boolean hasTargetSubID()
    {
        return hasTargetSubID;
    }


    private int targetSubIDOffset;

    private int targetSubIDLength;

    public int targetSubIDLength()
    {
        if (!hasTargetSubID)
        {
            throw new IllegalArgumentException("No value for optional field: TargetSubID");
        }

        return targetSubIDLength;
    }

    public String targetSubIDAsString()
    {
        return hasTargetSubID ? new String(targetSubID, 0, targetSubIDLength) : null;
    }

    public void targetSubID(final AsciiSequenceView view)
    {
        if (!hasTargetSubID)
        {
            throw new IllegalArgumentException("No value for optional field: TargetSubID");
        }

        view.wrap(buffer, targetSubIDOffset, targetSubIDLength);
    }


    private char[] targetLocationID = new char[1];

    private boolean hasTargetLocationID;

    public char[] targetLocationID()
    {
        if (!hasTargetLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: TargetLocationID");
        }

        return targetLocationID;
    }

    public boolean hasTargetLocationID()
    {
        return hasTargetLocationID;
    }


    private int targetLocationIDOffset;

    private int targetLocationIDLength;

    public int targetLocationIDLength()
    {
        if (!hasTargetLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: TargetLocationID");
        }

        return targetLocationIDLength;
    }

    public String targetLocationIDAsString()
    {
        return hasTargetLocationID ? new String(targetLocationID, 0, targetLocationIDLength) : null;
    }

    public void targetLocationID(final AsciiSequenceView view)
    {
        if (!hasTargetLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: TargetLocationID");
        }

        view.wrap(buffer, targetLocationIDOffset, targetLocationIDLength);
    }


    private char[] onBehalfOfSubID = new char[1];

    private boolean hasOnBehalfOfSubID;

    public char[] onBehalfOfSubID()
    {
        if (!hasOnBehalfOfSubID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfSubID");
        }

        return onBehalfOfSubID;
    }

    public boolean hasOnBehalfOfSubID()
    {
        return hasOnBehalfOfSubID;
    }


    private int onBehalfOfSubIDOffset;

    private int onBehalfOfSubIDLength;

    public int onBehalfOfSubIDLength()
    {
        if (!hasOnBehalfOfSubID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfSubID");
        }

        return onBehalfOfSubIDLength;
    }

    public String onBehalfOfSubIDAsString()
    {
        return hasOnBehalfOfSubID ? new String(onBehalfOfSubID, 0, onBehalfOfSubIDLength) : null;
    }

    public void onBehalfOfSubID(final AsciiSequenceView view)
    {
        if (!hasOnBehalfOfSubID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfSubID");
        }

        view.wrap(buffer, onBehalfOfSubIDOffset, onBehalfOfSubIDLength);
    }


    private char[] onBehalfOfLocationID = new char[1];

    private boolean hasOnBehalfOfLocationID;

    public char[] onBehalfOfLocationID()
    {
        if (!hasOnBehalfOfLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfLocationID");
        }

        return onBehalfOfLocationID;
    }

    public boolean hasOnBehalfOfLocationID()
    {
        return hasOnBehalfOfLocationID;
    }


    private int onBehalfOfLocationIDOffset;

    private int onBehalfOfLocationIDLength;

    public int onBehalfOfLocationIDLength()
    {
        if (!hasOnBehalfOfLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfLocationID");
        }

        return onBehalfOfLocationIDLength;
    }

    public String onBehalfOfLocationIDAsString()
    {
        return hasOnBehalfOfLocationID ? new String(onBehalfOfLocationID, 0, onBehalfOfLocationIDLength) : null;
    }

    public void onBehalfOfLocationID(final AsciiSequenceView view)
    {
        if (!hasOnBehalfOfLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: OnBehalfOfLocationID");
        }

        view.wrap(buffer, onBehalfOfLocationIDOffset, onBehalfOfLocationIDLength);
    }


    private char[] deliverToSubID = new char[1];

    private boolean hasDeliverToSubID;

    public char[] deliverToSubID()
    {
        if (!hasDeliverToSubID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToSubID");
        }

        return deliverToSubID;
    }

    public boolean hasDeliverToSubID()
    {
        return hasDeliverToSubID;
    }


    private int deliverToSubIDOffset;

    private int deliverToSubIDLength;

    public int deliverToSubIDLength()
    {
        if (!hasDeliverToSubID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToSubID");
        }

        return deliverToSubIDLength;
    }

    public String deliverToSubIDAsString()
    {
        return hasDeliverToSubID ? new String(deliverToSubID, 0, deliverToSubIDLength) : null;
    }

    public void deliverToSubID(final AsciiSequenceView view)
    {
        if (!hasDeliverToSubID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToSubID");
        }

        view.wrap(buffer, deliverToSubIDOffset, deliverToSubIDLength);
    }


    private char[] deliverToLocationID = new char[1];

    private boolean hasDeliverToLocationID;

    public char[] deliverToLocationID()
    {
        if (!hasDeliverToLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToLocationID");
        }

        return deliverToLocationID;
    }

    public boolean hasDeliverToLocationID()
    {
        return hasDeliverToLocationID;
    }


    private int deliverToLocationIDOffset;

    private int deliverToLocationIDLength;

    public int deliverToLocationIDLength()
    {
        if (!hasDeliverToLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToLocationID");
        }

        return deliverToLocationIDLength;
    }

    public String deliverToLocationIDAsString()
    {
        return hasDeliverToLocationID ? new String(deliverToLocationID, 0, deliverToLocationIDLength) : null;
    }

    public void deliverToLocationID(final AsciiSequenceView view)
    {
        if (!hasDeliverToLocationID)
        {
            throw new IllegalArgumentException("No value for optional field: DeliverToLocationID");
        }

        view.wrap(buffer, deliverToLocationIDOffset, deliverToLocationIDLength);
    }


    private boolean possDupFlag;

    private boolean hasPossDupFlag;

    public boolean possDupFlag()
    {
        if (!hasPossDupFlag)
        {
            throw new IllegalArgumentException("No value for optional field: PossDupFlag");
        }

        return possDupFlag;
    }

    public boolean hasPossDupFlag()
    {
        return hasPossDupFlag;
    }



    private boolean possResend;

    private boolean hasPossResend;

    public boolean possResend()
    {
        if (!hasPossResend)
        {
            throw new IllegalArgumentException("No value for optional field: PossResend");
        }

        return possResend;
    }

    public boolean hasPossResend()
    {
        return hasPossResend;
    }



    private byte[] sendingTime = new byte[24];

    public byte[] sendingTime()
    {
        return sendingTime;
    }


    private int sendingTimeOffset;

    private int sendingTimeLength;

    public int sendingTimeLength()
    {
        return sendingTimeLength;
    }

    public String sendingTimeAsString()
    {
        return new String(sendingTime, 0, sendingTimeLength);
    }

    public void sendingTime(final AsciiSequenceView view)
    {
        view.wrap(buffer, sendingTimeOffset, sendingTimeLength);
    }


    private byte[] origSendingTime = new byte[24];

    private boolean hasOrigSendingTime;

    public byte[] origSendingTime()
    {
        if (!hasOrigSendingTime)
        {
            throw new IllegalArgumentException("No value for optional field: OrigSendingTime");
        }

        return origSendingTime;
    }

    public boolean hasOrigSendingTime()
    {
        return hasOrigSendingTime;
    }


    private int origSendingTimeOffset;

    private int origSendingTimeLength;

    public int origSendingTimeLength()
    {
        if (!hasOrigSendingTime)
        {
            throw new IllegalArgumentException("No value for optional field: OrigSendingTime");
        }

        return origSendingTimeLength;
    }

    public String origSendingTimeAsString()
    {
        return hasOrigSendingTime ? new String(origSendingTime, 0, origSendingTimeLength) : null;
    }

    public void origSendingTime(final AsciiSequenceView view)
    {
        if (!hasOrigSendingTime)
        {
            throw new IllegalArgumentException("No value for optional field: OrigSendingTime");
        }

        view.wrap(buffer, origSendingTimeOffset, origSendingTimeLength);
    }


    private int xmlDataLen = MISSING_INT;

    private boolean hasXmlDataLen;

    public int xmlDataLen()
    {
        if (!hasXmlDataLen)
        {
            throw new IllegalArgumentException("No value for optional field: XmlDataLen");
        }

        return xmlDataLen;
    }

    public boolean hasXmlDataLen()
    {
        return hasXmlDataLen;
    }



    private byte[] xmlData = new byte[1];

    private boolean hasXmlData;

    public byte[] xmlData()
    {
        if (!hasXmlData)
        {
            throw new IllegalArgumentException("No value for optional field: XmlData");
        }

        return xmlData;
    }

    public boolean hasXmlData()
    {
        return hasXmlData;
    }



    private char[] messageEncoding = new char[1];

    private boolean hasMessageEncoding;

    public char[] messageEncoding()
    {
        if (!hasMessageEncoding)
        {
            throw new IllegalArgumentException("No value for optional field: MessageEncoding");
        }

        return messageEncoding;
    }

    public boolean hasMessageEncoding()
    {
        return hasMessageEncoding;
    }


    private int messageEncodingOffset;

    private int messageEncodingLength;

    public int messageEncodingLength()
    {
        if (!hasMessageEncoding)
        {
            throw new IllegalArgumentException("No value for optional field: MessageEncoding");
        }

        return messageEncodingLength;
    }

    public String messageEncodingAsString()
    {
        return hasMessageEncoding ? new String(messageEncoding, 0, messageEncodingLength) : null;
    }

    public void messageEncoding(final AsciiSequenceView view)
    {
        if (!hasMessageEncoding)
        {
            throw new IllegalArgumentException("No value for optional field: MessageEncoding");
        }

        view.wrap(buffer, messageEncodingOffset, messageEncodingLength);
    }


    private final CharArrayWrapper messageEncodingWrapper = new CharArrayWrapper();
    public MessageEncoding messageEncodingAsEnum()
    {
        if (!hasMessageEncoding)
 return MessageEncoding.NULL_VAL;
        messageEncodingWrapper.wrap(messageEncoding(), messageEncodingLength);
        return MessageEncoding.decode(messageEncodingWrapper);
    }

    private int lastMsgSeqNumProcessed = MISSING_INT;

    private boolean hasLastMsgSeqNumProcessed;

    public int lastMsgSeqNumProcessed()
    {
        if (!hasLastMsgSeqNumProcessed)
        {
            throw new IllegalArgumentException("No value for optional field: LastMsgSeqNumProcessed");
        }

        return lastMsgSeqNumProcessed;
    }

    public boolean hasLastMsgSeqNumProcessed()
    {
        return hasLastMsgSeqNumProcessed;
    }



    private char[] applVerID = new char[1];

    private boolean hasApplVerID;

    public char[] applVerID()
    {
        if (!hasApplVerID)
        {
            throw new IllegalArgumentException("No value for optional field: ApplVerID");
        }

        return applVerID;
    }

    public boolean hasApplVerID()
    {
        return hasApplVerID;
    }


    private int applVerIDOffset;

    private int applVerIDLength;

    public int applVerIDLength()
    {
        if (!hasApplVerID)
        {
            throw new IllegalArgumentException("No value for optional field: ApplVerID");
        }

        return applVerIDLength;
    }

    public String applVerIDAsString()
    {
        return hasApplVerID ? new String(applVerID, 0, applVerIDLength) : null;
    }

    public void applVerID(final AsciiSequenceView view)
    {
        if (!hasApplVerID)
        {
            throw new IllegalArgumentException("No value for optional field: ApplVerID");
        }

        view.wrap(buffer, applVerIDOffset, applVerIDLength);
    }


    private final CharArrayWrapper applVerIDWrapper = new CharArrayWrapper();
    public ApplVerID applVerIDAsEnum()
    {
        if (!hasApplVerID)
 return ApplVerID.NULL_VAL;
        applVerIDWrapper.wrap(applVerID(), applVerIDLength);
        return ApplVerID.decode(applVerIDWrapper);
    }

    private char[] cstmApplVerID = new char[1];

    private boolean hasCstmApplVerID;

    public char[] cstmApplVerID()
    {
        if (!hasCstmApplVerID)
        {
            throw new IllegalArgumentException("No value for optional field: CstmApplVerID");
        }

        return cstmApplVerID;
    }

    public boolean hasCstmApplVerID()
    {
        return hasCstmApplVerID;
    }


    private int cstmApplVerIDOffset;

    private int cstmApplVerIDLength;

    public int cstmApplVerIDLength()
    {
        if (!hasCstmApplVerID)
        {
            throw new IllegalArgumentException("No value for optional field: CstmApplVerID");
        }

        return cstmApplVerIDLength;
    }

    public String cstmApplVerIDAsString()
    {
        return hasCstmApplVerID ? new String(cstmApplVerID, 0, cstmApplVerIDLength) : null;
    }

    public void cstmApplVerID(final AsciiSequenceView view)
    {
        if (!hasCstmApplVerID)
        {
            throw new IllegalArgumentException("No value for optional field: CstmApplVerID");
        }

        view.wrap(buffer, cstmApplVerIDOffset, cstmApplVerIDLength);
    }


    public int decode(final AsciiBuffer buffer, final int offset, final int length)
    {
        // Decode Header
        int seenFieldCount = 0;
        if (CODEC_VALIDATION_ENABLED)
        {
            missingRequiredFields.copy(REQUIRED_FIELDS);
            alreadyVisitedFields.clear();
        }
        this.buffer = buffer;
        final int end = offset + length;
        int position = offset;
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
                else if (seenFieldCount == 0 && tag != 8)
                {
                    invalidTagId = tag;
                    rejectReason = 14;
                }
                else if (seenFieldCount == 1 && tag != 9)
                {
                    invalidTagId = tag;
                    rejectReason = 14;
                }
                else if (seenFieldCount == 2 && tag != 35)
                {
                    invalidTagId = tag;
                    rejectReason = 14;
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
            case Constants.BEGIN_STRING:
                beginString = buffer.getChars(beginString, valueOffset, valueLength);
                beginStringOffset = valueOffset;
                beginStringLength = valueLength;
                break;

            case Constants.BODY_LENGTH:
                bodyLength = getInt(buffer, valueOffset, endOfField, 9, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.MSG_TYPE:
                msgType = buffer.getChars(msgType, valueOffset, valueLength);
                msgTypeOffset = valueOffset;
                msgTypeLength = valueLength;
                break;

            case Constants.SENDER_COMP_ID:
                senderCompID = buffer.getChars(senderCompID, valueOffset, valueLength);
                senderCompIDOffset = valueOffset;
                senderCompIDLength = valueLength;
                break;

            case Constants.TARGET_COMP_ID:
                targetCompID = buffer.getChars(targetCompID, valueOffset, valueLength);
                targetCompIDOffset = valueOffset;
                targetCompIDLength = valueLength;
                break;

            case Constants.ON_BEHALF_OF_COMP_ID:
                hasOnBehalfOfCompID = true;
                onBehalfOfCompID = buffer.getChars(onBehalfOfCompID, valueOffset, valueLength);
                onBehalfOfCompIDOffset = valueOffset;
                onBehalfOfCompIDLength = valueLength;
                break;

            case Constants.DELIVER_TO_COMP_ID:
                hasDeliverToCompID = true;
                deliverToCompID = buffer.getChars(deliverToCompID, valueOffset, valueLength);
                deliverToCompIDOffset = valueOffset;
                deliverToCompIDLength = valueLength;
                break;

            case Constants.SECURE_DATA_LEN:
                hasSecureDataLen = true;
                secureDataLen = getInt(buffer, valueOffset, endOfField, 90, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SECURE_DATA:
                hasSecureData = true;
                secureData = buffer.getBytes(secureData, valueOffset, secureDataLen);
                endOfField = valueOffset + secureDataLen;
                break;

            case Constants.MSG_SEQ_NUM:
                msgSeqNum = getInt(buffer, valueOffset, endOfField, 34, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.SENDER_SUB_ID:
                hasSenderSubID = true;
                senderSubID = buffer.getChars(senderSubID, valueOffset, valueLength);
                senderSubIDOffset = valueOffset;
                senderSubIDLength = valueLength;
                break;

            case Constants.SENDER_LOCATION_ID:
                hasSenderLocationID = true;
                senderLocationID = buffer.getChars(senderLocationID, valueOffset, valueLength);
                senderLocationIDOffset = valueOffset;
                senderLocationIDLength = valueLength;
                break;

            case Constants.TARGET_SUB_ID:
                hasTargetSubID = true;
                targetSubID = buffer.getChars(targetSubID, valueOffset, valueLength);
                targetSubIDOffset = valueOffset;
                targetSubIDLength = valueLength;
                break;

            case Constants.TARGET_LOCATION_ID:
                hasTargetLocationID = true;
                targetLocationID = buffer.getChars(targetLocationID, valueOffset, valueLength);
                targetLocationIDOffset = valueOffset;
                targetLocationIDLength = valueLength;
                break;

            case Constants.ON_BEHALF_OF_SUB_ID:
                hasOnBehalfOfSubID = true;
                onBehalfOfSubID = buffer.getChars(onBehalfOfSubID, valueOffset, valueLength);
                onBehalfOfSubIDOffset = valueOffset;
                onBehalfOfSubIDLength = valueLength;
                break;

            case Constants.ON_BEHALF_OF_LOCATION_ID:
                hasOnBehalfOfLocationID = true;
                onBehalfOfLocationID = buffer.getChars(onBehalfOfLocationID, valueOffset, valueLength);
                onBehalfOfLocationIDOffset = valueOffset;
                onBehalfOfLocationIDLength = valueLength;
                break;

            case Constants.DELIVER_TO_SUB_ID:
                hasDeliverToSubID = true;
                deliverToSubID = buffer.getChars(deliverToSubID, valueOffset, valueLength);
                deliverToSubIDOffset = valueOffset;
                deliverToSubIDLength = valueLength;
                break;

            case Constants.DELIVER_TO_LOCATION_ID:
                hasDeliverToLocationID = true;
                deliverToLocationID = buffer.getChars(deliverToLocationID, valueOffset, valueLength);
                deliverToLocationIDOffset = valueOffset;
                deliverToLocationIDLength = valueLength;
                break;

            case Constants.POSS_DUP_FLAG:
                hasPossDupFlag = true;
                possDupFlag = buffer.getBoolean(valueOffset);
                break;

            case Constants.POSS_RESEND:
                hasPossResend = true;
                possResend = buffer.getBoolean(valueOffset);
                break;

            case Constants.SENDING_TIME:
                sendingTime = buffer.getBytes(sendingTime, valueOffset, valueLength);
                sendingTimeOffset = valueOffset;
                sendingTimeLength = valueLength;
                break;

            case Constants.ORIG_SENDING_TIME:
                hasOrigSendingTime = true;
                origSendingTime = buffer.getBytes(origSendingTime, valueOffset, valueLength);
                origSendingTimeOffset = valueOffset;
                origSendingTimeLength = valueLength;
                break;

            case Constants.XML_DATA_LEN:
                hasXmlDataLen = true;
                xmlDataLen = getInt(buffer, valueOffset, endOfField, 212, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.XML_DATA:
                hasXmlData = true;
                xmlData = buffer.getBytes(xmlData, valueOffset, xmlDataLen);
                endOfField = valueOffset + xmlDataLen;
                break;

            case Constants.MESSAGE_ENCODING:
                hasMessageEncoding = true;
                messageEncoding = buffer.getChars(messageEncoding, valueOffset, valueLength);
                messageEncodingOffset = valueOffset;
                messageEncodingLength = valueLength;
                break;

            case Constants.LAST_MSG_SEQ_NUM_PROCESSED:
                hasLastMsgSeqNumProcessed = true;
                lastMsgSeqNumProcessed = getInt(buffer, valueOffset, endOfField, 369, CODEC_VALIDATION_ENABLED);
                break;

            case Constants.APPL_VER_ID:
                hasApplVerID = true;
                applVerID = buffer.getChars(applVerID, valueOffset, valueLength);
                applVerIDOffset = valueOffset;
                applVerIDLength = valueLength;
                break;

            case Constants.CSTM_APPL_VER_ID:
                hasCstmApplVerID = true;
                cstmApplVerID = buffer.getChars(cstmApplVerID, valueOffset, valueLength);
                cstmApplVerIDOffset = valueOffset;
                cstmApplVerIDLength = valueLength;
                break;

            default:
                if (!CODEC_REJECT_UNKNOWN_FIELD_ENABLED)
                {
                    alreadyVisitedFields.remove(tag);
                }
                else
                {
                    if (!true)
                    {
                        unknownFields.add(tag);
                    }
                }
                if (CODEC_REJECT_UNKNOWN_FIELD_ENABLED || true)
                {
                    return position - offset;
                }

            }

            if (position < (endOfField + 1))
            {
                position = endOfField + 1;
            }
        }
        return position - offset;
    }

    public void reset()
    {
        resetSenderCompID();
        resetTargetCompID();
        resetOnBehalfOfCompID();
        resetDeliverToCompID();
        resetSecureDataLen();
        resetSecureData();
        resetMsgSeqNum();
        resetSenderSubID();
        resetSenderLocationID();
        resetTargetSubID();
        resetTargetLocationID();
        resetOnBehalfOfSubID();
        resetOnBehalfOfLocationID();
        resetDeliverToSubID();
        resetDeliverToLocationID();
        resetPossDupFlag();
        resetPossResend();
        resetSendingTime();
        resetOrigSendingTime();
        resetXmlDataLen();
        resetXmlData();
        resetMessageEncoding();
        resetLastMsgSeqNumProcessed();
        resetApplVerID();
        resetCstmApplVerID();
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

    public void resetSenderCompID()
    {
        senderCompIDOffset = 0;
        senderCompIDLength = 0;
    }

    public void resetTargetCompID()
    {
        targetCompIDOffset = 0;
        targetCompIDLength = 0;
    }

    public void resetOnBehalfOfCompID()
    {
        hasOnBehalfOfCompID = false;
    }

    public void resetDeliverToCompID()
    {
        hasDeliverToCompID = false;
    }

    public void resetSecureDataLen()
    {
        hasSecureDataLen = false;
    }

    public void resetSecureData()
    {
        hasSecureData = false;
    }

    public void resetMsgSeqNum()
    {
        msgSeqNum = MISSING_INT;
    }

    public void resetSenderSubID()
    {
        hasSenderSubID = false;
    }

    public void resetSenderLocationID()
    {
        hasSenderLocationID = false;
    }

    public void resetTargetSubID()
    {
        hasTargetSubID = false;
    }

    public void resetTargetLocationID()
    {
        hasTargetLocationID = false;
    }

    public void resetOnBehalfOfSubID()
    {
        hasOnBehalfOfSubID = false;
    }

    public void resetOnBehalfOfLocationID()
    {
        hasOnBehalfOfLocationID = false;
    }

    public void resetDeliverToSubID()
    {
        hasDeliverToSubID = false;
    }

    public void resetDeliverToLocationID()
    {
        hasDeliverToLocationID = false;
    }

    public void resetPossDupFlag()
    {
        hasPossDupFlag = false;
    }

    public void resetPossResend()
    {
        hasPossResend = false;
    }

    public void resetSendingTime()
    {
    }

    public void resetOrigSendingTime()
    {
        hasOrigSendingTime = false;
    }

    public void resetXmlDataLen()
    {
        hasXmlDataLen = false;
    }

    public void resetXmlData()
    {
        hasXmlData = false;
    }

    public void resetMessageEncoding()
    {
        hasMessageEncoding = false;
    }

    public void resetLastMsgSeqNumProcessed()
    {
        hasLastMsgSeqNumProcessed = false;
    }

    public void resetApplVerID()
    {
        hasApplVerID = false;
    }

    public void resetCstmApplVerID()
    {
        hasCstmApplVerID = false;
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
        builder.append("\"MessageName\": \"Header\",\n");
        indent(builder, level);
        builder.append("\"BeginString\": \"");
        builder.append(beginString(), 0, beginStringLength());
        builder.append("\",\n");


        indent(builder, level);
        builder.append("\"MsgType\": \"");
        builder.append(msgType(), 0, msgTypeLength());
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"SenderCompID\": \"");
        builder.append(senderCompID(), 0, senderCompIDLength());
        builder.append("\",\n");

        indent(builder, level);
        builder.append("\"TargetCompID\": \"");
        builder.append(targetCompID(), 0, targetCompIDLength());
        builder.append("\",\n");

        if (hasOnBehalfOfCompID())
        {
            indent(builder, level);
            builder.append("\"OnBehalfOfCompID\": \"");
            builder.append(onBehalfOfCompID(), 0, onBehalfOfCompIDLength());
            builder.append("\",\n");
        }

        if (hasDeliverToCompID())
        {
            indent(builder, level);
            builder.append("\"DeliverToCompID\": \"");
            builder.append(deliverToCompID(), 0, deliverToCompIDLength());
            builder.append("\",\n");
        }

        if (hasSecureDataLen())
        {
            indent(builder, level);
            builder.append("\"SecureDataLen\": \"");
            builder.append(secureDataLen);
            builder.append("\",\n");
        }

        if (hasSecureData())
        {
            indent(builder, level);
            builder.append("\"SecureData\": \"");
            appendData(builder, secureData, secureDataLen);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"MsgSeqNum\": \"");
        builder.append(msgSeqNum);
        builder.append("\",\n");

        if (hasSenderSubID())
        {
            indent(builder, level);
            builder.append("\"SenderSubID\": \"");
            builder.append(senderSubID(), 0, senderSubIDLength());
            builder.append("\",\n");
        }

        if (hasSenderLocationID())
        {
            indent(builder, level);
            builder.append("\"SenderLocationID\": \"");
            builder.append(senderLocationID(), 0, senderLocationIDLength());
            builder.append("\",\n");
        }

        if (hasTargetSubID())
        {
            indent(builder, level);
            builder.append("\"TargetSubID\": \"");
            builder.append(targetSubID(), 0, targetSubIDLength());
            builder.append("\",\n");
        }

        if (hasTargetLocationID())
        {
            indent(builder, level);
            builder.append("\"TargetLocationID\": \"");
            builder.append(targetLocationID(), 0, targetLocationIDLength());
            builder.append("\",\n");
        }

        if (hasOnBehalfOfSubID())
        {
            indent(builder, level);
            builder.append("\"OnBehalfOfSubID\": \"");
            builder.append(onBehalfOfSubID(), 0, onBehalfOfSubIDLength());
            builder.append("\",\n");
        }

        if (hasOnBehalfOfLocationID())
        {
            indent(builder, level);
            builder.append("\"OnBehalfOfLocationID\": \"");
            builder.append(onBehalfOfLocationID(), 0, onBehalfOfLocationIDLength());
            builder.append("\",\n");
        }

        if (hasDeliverToSubID())
        {
            indent(builder, level);
            builder.append("\"DeliverToSubID\": \"");
            builder.append(deliverToSubID(), 0, deliverToSubIDLength());
            builder.append("\",\n");
        }

        if (hasDeliverToLocationID())
        {
            indent(builder, level);
            builder.append("\"DeliverToLocationID\": \"");
            builder.append(deliverToLocationID(), 0, deliverToLocationIDLength());
            builder.append("\",\n");
        }

        if (hasPossDupFlag())
        {
            indent(builder, level);
            builder.append("\"PossDupFlag\": \"");
            builder.append(possDupFlag);
            builder.append("\",\n");
        }

        if (hasPossResend())
        {
            indent(builder, level);
            builder.append("\"PossResend\": \"");
            builder.append(possResend);
            builder.append("\",\n");
        }

        indent(builder, level);
        builder.append("\"SendingTime\": \"");
        appendData(builder, sendingTime, sendingTimeLength);
        builder.append("\",\n");

        if (hasOrigSendingTime())
        {
            indent(builder, level);
            builder.append("\"OrigSendingTime\": \"");
            appendData(builder, origSendingTime, origSendingTimeLength);
            builder.append("\",\n");
        }

        if (hasXmlDataLen())
        {
            indent(builder, level);
            builder.append("\"XmlDataLen\": \"");
            builder.append(xmlDataLen);
            builder.append("\",\n");
        }

        if (hasXmlData())
        {
            indent(builder, level);
            builder.append("\"XmlData\": \"");
            appendData(builder, xmlData, xmlDataLen);
            builder.append("\",\n");
        }

        if (hasMessageEncoding())
        {
            indent(builder, level);
            builder.append("\"MessageEncoding\": \"");
            builder.append(messageEncoding(), 0, messageEncodingLength());
            builder.append("\",\n");
        }

        if (hasLastMsgSeqNumProcessed())
        {
            indent(builder, level);
            builder.append("\"LastMsgSeqNumProcessed\": \"");
            builder.append(lastMsgSeqNumProcessed);
            builder.append("\",\n");
        }

        if (hasApplVerID())
        {
            indent(builder, level);
            builder.append("\"ApplVerID\": \"");
            builder.append(applVerID(), 0, applVerIDLength());
            builder.append("\",\n");
        }

        if (hasCstmApplVerID())
        {
            indent(builder, level);
            builder.append("\"CstmApplVerID\": \"");
            builder.append(cstmApplVerID(), 0, cstmApplVerIDLength());
            builder.append("\",\n");
        }
        indent(builder, level - 1);
        builder.append("}");
        return builder;
    }

    /**
     * {@inheritDoc}
     */
    public HeaderEncoder toEncoder(final Encoder encoder)
    {
        return toEncoder((HeaderEncoder)encoder);
    }

    public HeaderEncoder toEncoder(final HeaderEncoder encoder)
    {
        encoder.reset();
        encoder.beginString(beginString(), 0, beginStringLength());

        encoder.msgType(msgType(), 0, msgTypeLength());
        encoder.senderCompID(senderCompID(), 0, senderCompIDLength());
        encoder.targetCompID(targetCompID(), 0, targetCompIDLength());
        if (hasOnBehalfOfCompID())
        {
            encoder.onBehalfOfCompID(onBehalfOfCompID(), 0, onBehalfOfCompIDLength());
        }

        if (hasDeliverToCompID())
        {
            encoder.deliverToCompID(deliverToCompID(), 0, deliverToCompIDLength());
        }

        if (hasSecureDataLen())
        {
            encoder.secureDataLen(secureDataLen());
        }

        if (hasSecureData())
        {
            encoder.secureDataAsCopy(secureData(), 0, secureDataLen());
            encoder.secureDataLen(secureDataLen());
        }

        encoder.msgSeqNum(msgSeqNum());
        if (hasSenderSubID())
        {
            encoder.senderSubID(senderSubID(), 0, senderSubIDLength());
        }

        if (hasSenderLocationID())
        {
            encoder.senderLocationID(senderLocationID(), 0, senderLocationIDLength());
        }

        if (hasTargetSubID())
        {
            encoder.targetSubID(targetSubID(), 0, targetSubIDLength());
        }

        if (hasTargetLocationID())
        {
            encoder.targetLocationID(targetLocationID(), 0, targetLocationIDLength());
        }

        if (hasOnBehalfOfSubID())
        {
            encoder.onBehalfOfSubID(onBehalfOfSubID(), 0, onBehalfOfSubIDLength());
        }

        if (hasOnBehalfOfLocationID())
        {
            encoder.onBehalfOfLocationID(onBehalfOfLocationID(), 0, onBehalfOfLocationIDLength());
        }

        if (hasDeliverToSubID())
        {
            encoder.deliverToSubID(deliverToSubID(), 0, deliverToSubIDLength());
        }

        if (hasDeliverToLocationID())
        {
            encoder.deliverToLocationID(deliverToLocationID(), 0, deliverToLocationIDLength());
        }

        if (hasPossDupFlag())
        {
            encoder.possDupFlag(possDupFlag());
        }

        if (hasPossResend())
        {
            encoder.possResend(possResend());
        }

        encoder.sendingTimeAsCopy(sendingTime(), 0, sendingTimeLength());
        if (hasOrigSendingTime())
        {
            encoder.origSendingTimeAsCopy(origSendingTime(), 0, origSendingTimeLength());
        }

        if (hasXmlDataLen())
        {
            encoder.xmlDataLen(xmlDataLen());
        }

        if (hasXmlData())
        {
            encoder.xmlDataAsCopy(xmlData(), 0, xmlDataLen());
            encoder.xmlDataLen(xmlDataLen());
        }

        if (hasMessageEncoding())
        {
            encoder.messageEncoding(messageEncoding(), 0, messageEncodingLength());
        }

        if (hasLastMsgSeqNumProcessed())
        {
            encoder.lastMsgSeqNumProcessed(lastMsgSeqNumProcessed());
        }

        if (hasApplVerID())
        {
            encoder.applVerID(applVerID(), 0, applVerIDLength());
        }

        if (hasCstmApplVerID())
        {
            encoder.cstmApplVerID(cstmApplVerID(), 0, cstmApplVerIDLength());
        }
        return encoder;
    }

}
