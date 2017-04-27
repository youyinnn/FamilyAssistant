package utils;

import java.util.ArrayList;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class StringUtil {

    private StringUtil(){}

    /**
     * 处理字符串：将removePart从originalString中移除 返回移除后的字符串 用于删除friend_list字段的好友 返回新字段
     * @param originalString
     * @param removePart
     * @return
     */
    public static String removeStr(String originalString ,String removePart ){

        String[] strPart = originalString.split(removePart);

        String newString = "";

        for (String s : strPart){
            newString += s;
        }

        return newString;
    }

    /**
     * 获取好友id集
     * @param u_friend_list_field
     * @return
     */
    public static ArrayList<Integer> getFriendList(String u_friend_list_field){
        ArrayList<Integer> u_friend_list = new ArrayList<>();

        String[] u_friend_array = u_friend_list_field.split(",");

        for (String f_id : u_friend_array){
            if (!f_id.equals("**"))
                u_friend_list.add(Integer.valueOf(f_id));
        }

        return u_friend_list;
    }
}
