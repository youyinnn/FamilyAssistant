package dao.DaoImpl;

import dao.DaoInterface.SystemManagerDao;
import db.Table_Friend_List;
import db.Table_Location;
import db.Table_User;
import model.FriendInformation;
import model.User;
import model.UserLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
@SuppressWarnings("unchecked")
public class SystemManagerDaoImpl implements SystemManagerDao {

    private SystemManagerDaoImpl(){}

    private static SystemManagerDaoImpl instance = new SystemManagerDaoImpl();

    public static SystemManagerDaoImpl getInstance() {
        return instance;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemManagerDaoImpl.class);

    @Override
    public List<User> getAllUserInfo() {
        LOGGER.info("Get all user's info !");
        return BaseDao.getInstance().queryList(Table_User.TABLE_NAME,User.class);
    }

    @Override
    public List<FriendInformation> getAllFriendInfo() {
        LOGGER.info("Get all friend's info !");
        return BaseDao.getInstance().queryList(Table_Friend_List.TABLE_NAME,FriendInformation.class);
    }

    @Override
    public List<UserLocation> getAllUserLocation() {
        LOGGER.info("Get all user's location !");
        return BaseDao.getInstance().queryList(Table_Location.TABLE_NAME,UserLocation.class);
    }
}
