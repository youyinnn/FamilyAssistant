package dao;

import dao.DaoImpl.BaseDao;
import db.DBUtils;
import db.Table_Friend_List;
import db.Table_User;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.ConnectionContext;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by youyinnn on 2017/2/14.
 */
public class BaseDaoTest {

    Connection connection = null;

    @Before
    public void before() throws SQLException {
        connection = DBUtils.getConn();
        ConnectionContext.getInstance().bind(connection);
    }

    @After
    public void after(){
        ConnectionContext.getInstance().remove();

        DBUtils.release(connection);
    }

    @Test
    public void queryList() throws Exception {

        //List<User> list = BaseDao.getInstance().queryList(Table_User.TABLE_NAME,User.class);

        //List<User> list = BaseDao.getInstance().queryList(Table_User.TABLE_NAME,User.class,Table_User.FRIEND_MESSAGE_COLUMN_LIST);

        //List<User> list = BaseDao.getInstance().queryList(Table_User.TABLE_NAME,User.class,Table_User.COLUMN_ID,7,10);

        //List<User> list = BaseDao.getInstance().queryList(Table_User.TABLE_NAME,User.class,Table_User.COLUMN_ID,7,8,Table_User.FRIEND_MESSAGE_COLUMN_LIST);

        List<Integer> keys = new ArrayList<>();
        keys.add(15);
        keys.add(16);
        keys.add(18);

        List<User> list = BaseDao.getInstance().queryList(Table_User.TABLE_NAME,User.class,Table_User.COLUMN_ID,keys);

        for (User user : list){
            System.out.println(user);
        }
    }

    @Test
    public void queryOne() throws Exception {

        User user = (User) BaseDao.getInstance().queryOne(Table_User.TABLE_NAME,Table_User.COLUMN_ID,4,Table_User.USER_MESSAGE_COLUMN_LIST,User.class);

        System.out.println(user);
    }


    @Test
    public void insertEntity() throws Exception {
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put(Table_User.COLUMN_USERNAME,"youyinnn");
        fieldMap.put(Table_User.COLUMN_PASSWORD,123);
        fieldMap.put(Table_User.COLUMN_PHONE_NUMBER,13319613014L);
        fieldMap.put(Table_User.COLUMN_PORTRAIT_URL,"..\\FamilyAssistant\\Portrait\\youyinnn.jpg");
        fieldMap.put(Table_User.COLUMN_AGE,20);
        fieldMap.put(Table_User.COLUMN_CAREER,"stud");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1996,10,18);
        long time = gregorianCalendar.getTimeInMillis();
        Date date = new Date(time);
        fieldMap.put(Table_User.COLUMN_BIRTHDAY,date);
        fieldMap.put(Table_User.COLUMN_ADDRESS,"湖南省怀化市新晃侗族自治县新晃镇通达路梅林春天2栋三单元606房");
        fieldMap.put(Table_User.COLUMN_NAME,"黄君");
        fieldMap.put(Table_User.COLUMN_GENDER,"男");

        boolean a = BaseDao.getInstance().insertEntity(Table_User.TABLE_NAME,fieldMap);
        System.out.println(a);
    }

    @Test
    public void updateEntity() throws Exception {

        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put(Table_User.COLUMN_PASSWORD,1230);
        fieldMap.put(Table_User.COLUMN_CAREER,"student");
        boolean a = BaseDao.getInstance().updateEntity(Table_User.TABLE_NAME,Table_User.COLUMN_USERNAME,"testname",fieldMap);
        System.out.println(a);
    }

    @Test
    public void updateEntity2(){

        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put(Table_Friend_List.COLUMN_RELATIONSHIP,"father");
        fieldMap.put(Table_Friend_List.COLUMN_REMARK,"dad");

        Map<String ,Object> queryMap = new HashMap<>();
        queryMap.put(Table_Friend_List.COLUMN_ID,51);
        queryMap.put(Table_Friend_List.COLUMN_FRIEND_ID,52);

        boolean a = BaseDao.getInstance().updateEntity(Table_Friend_List.TABLE_NAME,queryMap,fieldMap);

        System.out.println(a);

    }

    @Test
    public void deleteEntity() throws Exception {
        Map<String,Object> fieldMap = new HashMap<>();

        fieldMap.put(Table_Friend_List.COLUMN_ID,52);
        fieldMap.put(Table_Friend_List.COLUMN_FRIEND_ID,51);

        boolean a = BaseDao.getInstance().deleteEntity(Table_Friend_List.TABLE_NAME,fieldMap);
        System.out.println(a);
    }

    @Test
    public void getValue() throws Exception {

        String value = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,Table_User.COLUMN_ID,3,Table_User.COLUMN_ADDRESS);

        System.out.println(value);
    }

}