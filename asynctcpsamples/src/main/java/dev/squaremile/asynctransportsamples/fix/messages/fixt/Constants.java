/* Generated Fix Gateway message codec */
package dev.squaremile.asynctransportsamples.fix.messages.fixt;

import org.agrona.collections.IntHashSet;
import uk.co.real_logic.artio.dictionary.CharArraySet;
public class Constants
{

    public static String VERSION = "FIXT.1.1";
    public static char[] VERSION_CHARS = VERSION.toCharArray();

    public static final String HEARTBEAT_MESSAGE_AS_STR = "0";
    public static final long HEARTBEAT_MESSAGE = 48L;

    public static final String TEST_REQUEST_MESSAGE_AS_STR = "1";
    public static final long TEST_REQUEST_MESSAGE = 49L;

    public static final String RESEND_REQUEST_MESSAGE_AS_STR = "2";
    public static final long RESEND_REQUEST_MESSAGE = 50L;

    public static final String REJECT_MESSAGE_AS_STR = "3";
    public static final long REJECT_MESSAGE = 51L;

    public static final String SEQUENCE_RESET_MESSAGE_AS_STR = "4";
    public static final long SEQUENCE_RESET_MESSAGE = 52L;

    public static final String LOGOUT_MESSAGE_AS_STR = "5";
    public static final long LOGOUT_MESSAGE = 53L;

    public static final String LOGON_MESSAGE_AS_STR = "A";
    public static final long LOGON_MESSAGE = 65L;

    public static final int BEGIN_STRING = 8;

    public static final int END_SEQ_NO = 16;

    public static final int SENDER_COMP_ID = 49;

    public static final int ORIG_SENDING_TIME = 122;

    public static final int HOP_SENDING_TIME = 629;

    public static final int POSS_DUP_FLAG = 43;

    public static final int ENCODED_TEXT = 355;

    public static final int TARGET_COMP_ID = 56;

    public static final int XML_DATA_LEN = 212;

    public static final int TEST_MESSAGE_INDICATOR = 464;

    public static final int ON_BEHALF_OF_COMP_ID = 115;

    public static final int ENCODED_TEXT_LEN = 354;

    public static final int NO_HOPS = 627;

    public static final int CSTM_APPL_VER_ID = 1129;

    public static final int REF_SEQ_NUM = 45;

    public static final int REF_APPL_VER_ID = 1130;

    public static final int BEGIN_SEQ_NO = 7;

    public static final int BODY_LENGTH = 9;

    public static final int RAW_DATA = 96;

    public static final int ON_BEHALF_OF_LOCATION_ID = 144;

    public static final int NEW_SEQ_NO = 36;

    public static final int ENCRYPT_METHOD = 98;

    public static final int SENDER_SUB_ID = 50;

    public static final int DEFAULT_APPL_VER_ID = 1137;

    public static final int TARGET_SUB_ID = 57;

    public static final int MSG_SEQ_NUM = 34;

    public static final int NEXT_EXPECTED_MSG_SEQ_NUM = 789;

    public static final int SECURE_DATA = 91;

    public static final int CHECK_SUM = 10;

    public static final int NO_MSG_TYPES = 384;

    public static final int SENDER_LOCATION_ID = 142;

    public static final int ON_BEHALF_OF_SUB_ID = 116;

    public static final int MAX_MESSAGE_SIZE = 383;

    public static final int RESET_SEQ_NUM_FLAG = 141;

    public static final int POSS_RESEND = 97;

    public static final int HOP_REF_ID = 630;

    public static final int TARGET_LOCATION_ID = 143;

    public static final int HOP_COMP_ID = 628;

    public static final int REF_CSTM_APPL_VER_ID = 1131;

    public static final int DELIVER_TO_COMP_ID = 128;

    public static final int REF_TAG_ID = 371;

    public static final int SENDING_TIME = 52;

    public static final int SECURE_DATA_LEN = 90;

    public static final int MSG_DIRECTION = 385;

    public static final int PASSWORD = 554;

    public static final int RAW_DATA_LENGTH = 95;

    public static final int DELIVER_TO_LOCATION_ID = 145;

    public static final int REF_MSG_TYPE = 372;

    public static final int APPL_VER_ID = 1128;

    public static final int TEXT = 58;

    public static final int MSG_TYPE = 35;

    public static final int SESSION_REJECT_REASON = 373;

    public static final int DELIVER_TO_SUB_ID = 129;

    public static final int MESSAGE_ENCODING = 347;

    public static final int SIGNATURE_LENGTH = 93;

    public static final int GAP_FILL_FLAG = 123;

    public static final int USERNAME = 553;

    public static final int SIGNATURE = 89;

    public static final int XML_DATA = 213;

    public static final int TEST_REQ_ID = 112;

    public static final int LAST_MSG_SEQ_NUM_PROCESSED = 369;

    public static final int HEART_BT_INT = 108;

    public static final IntHashSet ALL_FIELDS = new IntHashSet(124);
    static
    {
        ALL_FIELDS.add(Constants.BEGIN_STRING);
        ALL_FIELDS.add(Constants.END_SEQ_NO);
        ALL_FIELDS.add(Constants.SENDER_COMP_ID);
        ALL_FIELDS.add(Constants.ORIG_SENDING_TIME);
        ALL_FIELDS.add(Constants.HOP_SENDING_TIME);
        ALL_FIELDS.add(Constants.POSS_DUP_FLAG);
        ALL_FIELDS.add(Constants.ENCODED_TEXT);
        ALL_FIELDS.add(Constants.TARGET_COMP_ID);
        ALL_FIELDS.add(Constants.XML_DATA_LEN);
        ALL_FIELDS.add(Constants.TEST_MESSAGE_INDICATOR);
        ALL_FIELDS.add(Constants.ON_BEHALF_OF_COMP_ID);
        ALL_FIELDS.add(Constants.ENCODED_TEXT_LEN);
        ALL_FIELDS.add(Constants.NO_HOPS);
        ALL_FIELDS.add(Constants.CSTM_APPL_VER_ID);
        ALL_FIELDS.add(Constants.REF_SEQ_NUM);
        ALL_FIELDS.add(Constants.REF_APPL_VER_ID);
        ALL_FIELDS.add(Constants.BEGIN_SEQ_NO);
        ALL_FIELDS.add(Constants.BODY_LENGTH);
        ALL_FIELDS.add(Constants.RAW_DATA);
        ALL_FIELDS.add(Constants.ON_BEHALF_OF_LOCATION_ID);
        ALL_FIELDS.add(Constants.NEW_SEQ_NO);
        ALL_FIELDS.add(Constants.ENCRYPT_METHOD);
        ALL_FIELDS.add(Constants.SENDER_SUB_ID);
        ALL_FIELDS.add(Constants.DEFAULT_APPL_VER_ID);
        ALL_FIELDS.add(Constants.TARGET_SUB_ID);
        ALL_FIELDS.add(Constants.MSG_SEQ_NUM);
        ALL_FIELDS.add(Constants.NEXT_EXPECTED_MSG_SEQ_NUM);
        ALL_FIELDS.add(Constants.SECURE_DATA);
        ALL_FIELDS.add(Constants.CHECK_SUM);
        ALL_FIELDS.add(Constants.NO_MSG_TYPES);
        ALL_FIELDS.add(Constants.SENDER_LOCATION_ID);
        ALL_FIELDS.add(Constants.ON_BEHALF_OF_SUB_ID);
        ALL_FIELDS.add(Constants.MAX_MESSAGE_SIZE);
        ALL_FIELDS.add(Constants.RESET_SEQ_NUM_FLAG);
        ALL_FIELDS.add(Constants.POSS_RESEND);
        ALL_FIELDS.add(Constants.HOP_REF_ID);
        ALL_FIELDS.add(Constants.TARGET_LOCATION_ID);
        ALL_FIELDS.add(Constants.HOP_COMP_ID);
        ALL_FIELDS.add(Constants.REF_CSTM_APPL_VER_ID);
        ALL_FIELDS.add(Constants.DELIVER_TO_COMP_ID);
        ALL_FIELDS.add(Constants.REF_TAG_ID);
        ALL_FIELDS.add(Constants.SENDING_TIME);
        ALL_FIELDS.add(Constants.SECURE_DATA_LEN);
        ALL_FIELDS.add(Constants.MSG_DIRECTION);
        ALL_FIELDS.add(Constants.PASSWORD);
        ALL_FIELDS.add(Constants.RAW_DATA_LENGTH);
        ALL_FIELDS.add(Constants.DELIVER_TO_LOCATION_ID);
        ALL_FIELDS.add(Constants.REF_MSG_TYPE);
        ALL_FIELDS.add(Constants.APPL_VER_ID);
        ALL_FIELDS.add(Constants.TEXT);
        ALL_FIELDS.add(Constants.MSG_TYPE);
        ALL_FIELDS.add(Constants.SESSION_REJECT_REASON);
        ALL_FIELDS.add(Constants.DELIVER_TO_SUB_ID);
        ALL_FIELDS.add(Constants.MESSAGE_ENCODING);
        ALL_FIELDS.add(Constants.SIGNATURE_LENGTH);
        ALL_FIELDS.add(Constants.GAP_FILL_FLAG);
        ALL_FIELDS.add(Constants.USERNAME);
        ALL_FIELDS.add(Constants.SIGNATURE);
        ALL_FIELDS.add(Constants.XML_DATA);
        ALL_FIELDS.add(Constants.TEST_REQ_ID);
        ALL_FIELDS.add(Constants.LAST_MSG_SEQ_NUM_PROCESSED);
        ALL_FIELDS.add(Constants.HEART_BT_INT);
    }

}
