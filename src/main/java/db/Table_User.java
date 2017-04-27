package db;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/14
 */
public class Table_User {

    private Table_User(){}

    public static final String TABLE_NAME = "user";

    public static final String COLUMN_ID = "id";

    public static final String COLUMN_USERNAME = "username";

    public static final String COLUMN_PASSWORD = "password";

    public static final String COLUMN_PHONE_NUMBER = "phone_number";

    public static final String COLUMN_PORTRAIT_URL = "portrait_url";

    public static final String COLUMN_FRIEND_LIST = "friend_list";

    public static final String COLUMN_AGE = "age";

    public static final String COLUMN_CAREER = "career";

    public static final String COLUMN_BIRTHDAY = "birthday";

    public static final String COLUMN_ADDRESS = "address";

    public static final String COLUMN_NAME = "name";

    public static final String COLUMN_CARE = "care";

    public static final String COLUMN_BECARE = "becare";

    public static final String COLUMN_GENDER = "gender";

    private static String friend_message_columns[] =
            {
                    COLUMN_ID,
                    COLUMN_USERNAME,
                    COLUMN_PORTRAIT_URL,
                    COLUMN_GENDER,
                    COLUMN_BIRTHDAY,
                    COLUMN_ADDRESS,
                    COLUMN_CAREER,
                    COLUMN_PHONE_NUMBER
            };

    public static final List<String> FRIEND_MESSAGE_COLUMN_LIST = Arrays.asList(friend_message_columns);

    private static String user_message_column[] =
            {
                    COLUMN_ID,
                    COLUMN_AGE,
                    COLUMN_NAME,
                    COLUMN_USERNAME,
                    COLUMN_PORTRAIT_URL,
                    COLUMN_GENDER,
                    COLUMN_BIRTHDAY,
                    COLUMN_ADDRESS,
                    COLUMN_CAREER,
                    COLUMN_PHONE_NUMBER,
            };

    public static final List<String> USER_MESSAGE_COLUMN_LIST = Arrays.asList(user_message_column);

    private static String login_message_needed_column[] =
            {
                    COLUMN_ID,
                    COLUMN_PORTRAIT_URL,
                    COLUMN_USERNAME,
                    COLUMN_GENDER,
                    COLUMN_BIRTHDAY,
                    COLUMN_ADDRESS,
                    COLUMN_CAREER,
                    COLUMN_PHONE_NUMBER,
                    COLUMN_CARE,
                    COLUMN_BECARE,
            };

    public static final List<String> LOGIN_MESSAGE_NEEDED_LIST = Arrays.asList(login_message_needed_column);

    private static String location_message_needed_column[] =
            {
                    COLUMN_ID,
                    COLUMN_USERNAME,
                    COLUMN_PORTRAIT_URL
            };

    public static final List<String> LOCATION_MESSAGE_NEEDED_LIST = Arrays.asList(location_message_needed_column);
}
