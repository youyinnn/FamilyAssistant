package dao.DaoImpl;

import com.alibaba.fastjson.JSON;
import dao.DaoInterface.FriendSystemDao;
import db.Table_Friend_List;
import db.Table_User;
import model.FriendInformation;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public class FriendSystemDaoImpl implements FriendSystemDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(FriendSystemDaoImpl.class);

    private FriendSystemDaoImpl(){}

    private static FriendSystemDaoImpl instance = new FriendSystemDaoImpl();

    public static FriendSystemDaoImpl getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addFriend(int u_id, int f_id) {

        //创建一个多用fieldMap
        Map<String,Object> fieldMap = new HashMap<>();

        fieldMap.put(Table_Friend_List.COLUMN_ID,u_id);
        fieldMap.put(Table_Friend_List.COLUMN_FRIEND_ID,f_id);

        //先看两个id是否已经是好友
        List<FriendInformation> mark0 = BaseDao.getInstance().queryList(Table_Friend_List.TABLE_NAME, FriendInformation.class
                ,fieldMap);

        if (!mark0.isEmpty()){
            LOGGER.info("Two user has been build relationship before !");
            return false;
        }

        fieldMap.clear();

        //先读取两个id下的friend_list字段
        String u_friend_list = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,u_id,Table_User.COLUMN_FRIEND_LIST);
        String f_friend_list = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,f_id,Table_User.COLUMN_FRIEND_LIST);


        //把对方的id加到friend_list字段的末尾
        String new_u_friend_list = u_friend_list+f_id+",";
        String new_f_friend_list = f_friend_list+u_id+",";

        //更新自己的friend_list字段
        boolean mark1 = updateFriendListField(u_id,new_u_friend_list,fieldMap);
        boolean mark2 = updateFriendListField(f_id,new_f_friend_list,fieldMap);

        //插入两条记录到friend_list表中，说明对方是互相的好友
        boolean mark3 = updateFriendListTable(u_id,f_id,fieldMap);
        boolean mark4 = updateFriendListTable(f_id,u_id,fieldMap);

        if (mark1 && mark2 && mark3 && mark4){
            LOGGER.info("Build relationship between "+u_id+" and "+f_id+" !");
            return true;
        }else {
            LOGGER.info("Fail to"+" build relationship between "+u_id+" and "+f_id+" !");
            return false;
        }
    }

    private boolean updateFriendListField(int a, String new_a_list,Map<String,Object> fieldMap){

        //更新friend_list字段
        fieldMap.put(Table_User.COLUMN_FRIEND_LIST,new_a_list);
        boolean mark = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,Table_User.COLUMN_ID,a,fieldMap);

        //清空多用map
        fieldMap.clear();

        return mark;
    }

    private boolean updateFriendListTable(int a,int b,Map<String,Object> fieldMap){
        fieldMap.put(Table_Friend_List.COLUMN_ID,a);
        fieldMap.put(Table_Friend_List.COLUMN_FRIEND_ID,b);
        boolean mark = BaseDao.getInstance().insertEntity(Table_Friend_List.TABLE_NAME,fieldMap);

        fieldMap.clear();

        return mark;
    }

    @Override
    public boolean deleteFriend(int u_id, int f_id) {

        //先看要删除的好友是不是特别关心 或者被特别关心
        Integer u_care_id = (Integer) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,u_id,Table_User.COLUMN_CARE);
        Integer u_becare_id = (Integer) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,u_id,Table_User.COLUMN_BECARE);


        //如果是 就移除
        if ((u_care_id != null) && (u_care_id == f_id)){
            UserSystemDaoImpl.getInstance().removeCare(u_id);
        }else if ((u_becare_id != null) && (u_becare_id == f_id)){
            UserSystemDaoImpl.getInstance().removeCare(f_id);
        }

        //先读取两个id下的friend_list字段
        String ufriend_list = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,u_id,Table_User.COLUMN_FRIEND_LIST);
        String ffriend_list = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,f_id,Table_User.COLUMN_FRIEND_LIST);

        //创建一个多用fieldMap
        Map<String,Object> fieldMap = new HashMap<>();

        //把对方的id从字段里面移除掉
        String newUfriend_list = StringUtil.removeStr(ufriend_list,f_id+",");
        String newFfriend_list = StringUtil.removeStr(ffriend_list,u_id+",");

        //更新自己的字段
        boolean mark1 = updateFriendListField(u_id,newUfriend_list,fieldMap);
        boolean mark2 = updateFriendListField(f_id,newFfriend_list,fieldMap);

        //删除互相的好友记录
        boolean mark3 = deleteFriendListTable(u_id,f_id,fieldMap);
        boolean mark4 = deleteFriendListTable(f_id,u_id,fieldMap);


        if (mark1 && mark2 && mark3 && mark4){
            LOGGER.info("Release relationship between "+u_id+" and "+f_id+" !");
            return true;
        }else {
            LOGGER.info("Fail to "+" release relationship between "+u_id+" and "+f_id+" !");
            return false;
        }

    }

    private boolean deleteFriendListTable(int id,int f_id,Map<String,Object> fieldMap){
        fieldMap.put(Table_Friend_List.COLUMN_ID,id);
        fieldMap.put(Table_Friend_List.COLUMN_FRIEND_ID,f_id);
        boolean mark = BaseDao.getInstance().deleteEntity(Table_Friend_List.TABLE_NAME,fieldMap);

        fieldMap.clear();

        return mark;
    }


    @SuppressWarnings("unchecked")
    @Override
    public String searchUserInfo(String username) {

        User user = (User) BaseDao.getInstance().queryOne(Table_User.TABLE_NAME,Table_User.COLUMN_USERNAME,
                username,Table_User.USER_MESSAGE_COLUMN_LIST,User.class);

        String info_json = JSON.toJSONString(user);

        if (info_json.equals("null")){
            LOGGER.info("Searching the nonexistent user !");
        }else {
            LOGGER.info("Searching user : [ id :"+user.getId()+" ,username: "+username+" ] !");
        }

        return info_json;
    }
}
