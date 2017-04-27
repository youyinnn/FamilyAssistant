package dao.DaoImpl;

import dao.DaoInterface.LoginSystemDao;
import db.Table_User;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UpLoadUtil;

import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
public class LoginSystemDaoImpl implements LoginSystemDao {

    private LoginSystemDaoImpl(){}

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSystemDaoImpl.class);

    private static LoginSystemDaoImpl instance = new LoginSystemDaoImpl();

    public static LoginSystemDaoImpl getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public User login(String username, String password) {

        Map<String,Object> fieldMap = new HashMap<>();

        fieldMap.put(Table_User.COLUMN_USERNAME,username);
        fieldMap.put(Table_User.COLUMN_PASSWORD,password);

        User user = (User) BaseDao.getInstance().queryOne(Table_User.TABLE_NAME,Table_User.LOGIN_MESSAGE_NEEDED_LIST,
                fieldMap,User.class);

        if (user != null){
            LOGGER.info("User [ "+username+" ] is login !");
        }else {
            LOGGER.info("User [ "+username+" ] login fail !");
        }

        return user;
    }

    @Override
    public boolean signIn(Map<String, Object> fieldMap) {
        if (verify((String) fieldMap.get(Table_User.COLUMN_USERNAME))){
            LOGGER.info("SignIn fail cause by the existed username !");
            return false;
        }else {

            String portrait_url = (String) fieldMap.get(Table_User.COLUMN_PORTRAIT_URL);

            InputStream in = (InputStream) fieldMap.get("portraitInputStream");

            UpLoadUtil.outputFile(portrait_url,in);

            fieldMap.remove("portraitInputStream");

            //移除本地存储路径
            fieldMap.remove(Table_User.COLUMN_PORTRAIT_URL);

            //发布路径
            portrait_url = "http://youyinnn.cn/"+
                    portrait_url.substring(portrait_url.indexOf("FamilyAssistant"));

            //更改为访问路径
            fieldMap.put(Table_User.COLUMN_PORTRAIT_URL,portrait_url);

            //接收生日毫秒数 转换成Date
            String time = (String) fieldMap.get(Table_User.COLUMN_BIRTHDAY);

            Date birthday = new Date(Long.parseLong(time));

            fieldMap.remove(Table_User.COLUMN_BIRTHDAY);

            fieldMap.put(Table_User.COLUMN_BIRTHDAY,birthday);

            LOGGER.info("User [ "+fieldMap.get(Table_User.COLUMN_USERNAME)+" ] sign in !");
            return BaseDao.getInstance().insertEntity(Table_User.TABLE_NAME,fieldMap);
        }

    }

    @Override
    public boolean verify(String username) {
        String dbUsername = (String) BaseDao.getInstance().getValue(Table_User.TABLE_NAME,
                Table_User.COLUMN_USERNAME,username,Table_User.COLUMN_USERNAME);

        if (dbUsername == null){
            LOGGER.info("Username : [ "+username+" ] verify fail !");
            return false;
        }else {
            LOGGER.info("Username : [ "+username+" ] verify success !");
            return  true;
        }
    }
}
