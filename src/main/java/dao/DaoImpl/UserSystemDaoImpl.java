package dao.DaoImpl;

import com.alibaba.fastjson.JSON;
import dao.DaoInterface.UserSystemDao;
import db.Table_Friend_List;
import db.Table_Location;
import db.Table_User;
import model.FriendInformation;
import model.User;
import model.UserLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.StringUtil;
import utils.UpLoadUtil;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public class UserSystemDaoImpl implements UserSystemDao {

    private UserSystemDaoImpl(){}

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSystemDaoImpl.class);

    private static UserSystemDaoImpl instance = new UserSystemDaoImpl();

    public static UserSystemDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean changePassword(String username, String newPassword) {

        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put(Table_User.COLUMN_PASSWORD,newPassword);


        boolean mark1 = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,
                Table_User.COLUMN_USERNAME,username,fieldMap);

        if (mark1){
            LOGGER.info("User : [ "+username+" ] change password !");
        }else {
            LOGGER.info("Can't find user [ "+username+" ] to change password !");
        }

        return mark1;
    }

    @Override
    public boolean changeUserInformation(Map<String, Object> fieldMap) {

        Integer id = new Integer((String) fieldMap.get(Table_User.COLUMN_ID));

        fieldMap.remove(Table_User.COLUMN_ID);

        //接收生日毫秒数 转换成Date
        String time = (String) fieldMap.get(Table_User.COLUMN_BIRTHDAY);

        Date birthday = new Date(Long.parseLong(time));

        fieldMap.remove(Table_User.COLUMN_BIRTHDAY);

        fieldMap.put(Table_User.COLUMN_BIRTHDAY,birthday);

        boolean mark1 = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,Table_User.COLUMN_ID,id,fieldMap);

        if (mark1){
            LOGGER.info("UpDate user info which id is : [ "+id+" ] !");
        }else {
            LOGGER.info("Can't find user [ "+id+" ] to change info !");
        }
        return mark1;
    }

    @Override
    public boolean changeFriendInformation(Map<String, Object> condition_value_map, Map<String, Object> fieldMap) {

        LOGGER.info("Change the friend info between :"+condition_value_map.get(Table_Friend_List.COLUMN_ID)+" and "
                +condition_value_map.get(Table_Friend_List.COLUMN_FRIEND_ID));

        return BaseDao.getInstance().updateEntity(Table_Friend_List.TABLE_NAME,condition_value_map,fieldMap);
    }


    @Override
    public boolean changePortrait(Map<String, Object> fieldMap) {

        String portrait_url = (String) fieldMap.get(Table_User.COLUMN_PORTRAIT_URL);

        InputStream in = (InputStream) fieldMap.get("portraitInputStream");

        UpLoadUtil.outputFile(portrait_url,in);

        LOGGER.info("Change portrait : "+fieldMap.get(Table_User.COLUMN_USERNAME));

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String showFriendInformation(int id) {

        User user = (User) BaseDao.getInstance().queryOne(Table_User.TABLE_NAME,Table_User.COLUMN_ID,
                        id,Table_User.FRIEND_MESSAGE_COLUMN_LIST,User.class);

        LOGGER.info("Show info of friend :"+id+" !");

        return JSON.toJSONString(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getLocation(int u_id, String u_location) {

        //先update自己的location
        Map<String,Object> update_location_fieldMap = new HashMap<>();
        update_location_fieldMap.put(Table_Location.COLUMN_LOCATION,u_location);
        boolean mark1 = BaseDao.getInstance().updateEntity(Table_Location.TABLE_NAME,
                                    Table_Location.COLUMN_ID,u_id,update_location_fieldMap);

        update_location_fieldMap.put(Table_Location.COLUMN_ID,u_id);
        //如果是第一次上传location 即表中没有这个用户的location 就增加记录
        if (!mark1){
            LOGGER.info("Insert user :"+u_id+"'s location !");
            BaseDao.getInstance().insertEntity(Table_Location.TABLE_NAME,update_location_fieldMap);
        }

        //获取好友列表字段
        String u_friend_list_field = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME ,
                        Table_User.COLUMN_ID , u_id , Table_User.COLUMN_FRIEND_LIST);

        if (u_friend_list_field.equals("**,")){
            LOGGER.info("This user has no friend to get location !");
            return null;
        }

        //获取好友id集
        ArrayList<Integer> u_friend_id_list = StringUtil.getFriendList(u_friend_list_field);

        //获取对应id集的username portrait_url字段
        List<User> friend_info_list = BaseDao.getInstance().queryList(
                Table_User.TABLE_NAME,User.class,Table_User.COLUMN_ID,u_friend_id_list,Table_User.LOCATION_MESSAGE_NEEDED_LIST);


        Map<Integer,User> user_id_info_map = new HashMap<>();

        for (User user : friend_info_list) {
            System.out.println(user);
            user_id_info_map.put(user.getId(),user);
        }
        //获取所有好友的location
        List<UserLocation> u_friend_location_list = BaseDao.getInstance().queryList(
                Table_Location.TABLE_NAME,UserLocation.class,Table_Location.COLUMN_ID,u_friend_id_list);


        //把username portrait_url字段，和location做对应处理
        for (UserLocation userLocation : u_friend_location_list) {
            User user = user_id_info_map.get(userLocation.getId());
            userLocation.setUsername(user.getUsername());
            userLocation.setPortrait_url(user.getPortrait_url());
        }

        LOGGER.info("Get : "+u_id+" 's friend's location !");

        return JSON.toJSONString(u_friend_location_list);
    }

    @Override
    public boolean changeCare(int u_id, int care_id) {

        Map<String,Object> fieldMap = new HashMap<>();
        //寻找care_id是否已经被关注了 如果已经被关注了 就不能设置关心
        Object mark1 = BaseDao.getInstance().getValue(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,care_id,Table_User.COLUMN_BECARE);

        if (mark1 != null){
            LOGGER.info("Can't care ID :"+care_id+" cause this user has been cared !");
            return false;
        }


        fieldMap.put(Table_User.COLUMN_BECARE,null);
        //寻找becare列中是否有u_id 如果有就改为null
        BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,
                    Table_User.COLUMN_BECARE,u_id,fieldMap);
        fieldMap.clear();


        //把care_id放入u_id的care字段中

        fieldMap.put(Table_User.COLUMN_CARE,care_id);

        boolean mark2 = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID, u_id,fieldMap);

        fieldMap.clear();
        //把u_id放入care_id的becare字段中
        fieldMap.put(Table_User.COLUMN_BECARE,u_id);

        boolean mark3 = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,care_id,fieldMap);

        if (mark2 && mark3){
            LOGGER.info(" ID: "+u_id+" care ID: "+care_id+" success !");
            return true;
        }else {
            LOGGER.info(" ID: "+u_id+" care ID: "+care_id+" fail !");
            return false;
        }

    }

    @Override
    public boolean removeCare(int u_id) {

        Map<String,Object> fieldMap = new HashMap<>();

        fieldMap.put(Table_User.COLUMN_CARE,null);

        //先看u_id care了谁
        Object care_id = BaseDao.getInstance().getValue(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,u_id,Table_User.COLUMN_CARE);

        if (care_id == null){
            LOGGER.info("ID :"+u_id+" never care someone !");
            return false;
        }

        //把u_id的care字段清空
        boolean mark2 = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,u_id,fieldMap);

        fieldMap.clear();

        fieldMap.put(Table_User.COLUMN_BECARE,null);
        //把care_id的becare字段清空
        boolean mark3 = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,care_id,fieldMap);

        if (mark2 && mark3){
            LOGGER.info("Remove care :"+u_id+" !");
            return true;
        }else {
            LOGGER.info("Can't remove care :"+u_id+" !");
            return false;
        }
    }
    @Override
    public int showCareByWho(int u_id) {

        Object care_by = BaseDao.getInstance().getValue(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,u_id,Table_User.COLUMN_BECARE);

        LOGGER.info("Show care by !");
        if (care_by == null ){
            return 0;
        }else {
            return (int) care_by;
        }

    }

    @Override
    public ArrayList<Integer> getFriendList(int u_id) {

        String u_friend_list_field = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,u_id,Table_User.COLUMN_FRIEND_LIST);

        LOGGER.info("Get friend list of :"+u_id+" !");
        if (u_friend_list_field == null || u_friend_list_field.equals("**,")){
            return null;
        }else {
            return StringUtil.getFriendList(u_friend_list_field);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<FriendInformation> getFriendsInfo(int u_id) {

        //首先获取用户的friend_list字段
        String u_friend_id_field = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,
                Table_User.COLUMN_ID,u_id,Table_User.COLUMN_FRIEND_LIST);

        //获取好友id集
        ArrayList<Integer> u_friend_id_list = StringUtil.getFriendList(u_friend_id_field);

        ArrayList<FriendInformation> friendsInfo = new ArrayList<>();

        Map<String,Object> fieldMap = new HashMap<>();
        for (Integer f_id : u_friend_id_list){
            fieldMap.put(Table_Friend_List.COLUMN_ID,u_id);
            fieldMap.put(Table_Friend_List.COLUMN_FRIEND_ID,f_id);
            FriendInformation friend_info = (FriendInformation) BaseDao.getInstance().queryOne(Table_Friend_List.TABLE_NAME,
                    Table_Friend_List.friend_info_list,fieldMap,FriendInformation.class);

            friendsInfo.add(friend_info);

            fieldMap.clear();
        }

        LOGGER.info("Get "+u_id+"'s friends info !");
        return friendsInfo;
    }
}
