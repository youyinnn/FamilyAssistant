package db;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public class Table_Friend_List {

    private Table_Friend_List(){}

    public static final String TABLE_NAME = "friend_list";

    public static final String COLUMN_ID = "id";

    public static final String COLUMN_FRIEND_ID = "friend_id";

    public static final String COLUMN_RELATIONSHIP = "relationship";

    public static final String COLUMN_REMARK = "remark";

    private static String friend_info_columns[] =
            {
                    COLUMN_FRIEND_ID,
                    COLUMN_RELATIONSHIP,
                    COLUMN_REMARK
            };

    public static final List<String> friend_info_list = Arrays.asList(friend_info_columns);
}
