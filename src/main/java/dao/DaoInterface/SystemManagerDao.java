package dao.DaoInterface;

import model.FriendInformation;
import model.UserLocation;

import java.util.List;

/**
 * Created by youyinnn on 2017/2/21.
 */
public interface SystemManagerDao {

    /**
     * 获取所有用户信息
     * @return
     */
    List getAllUserInfo();

    /**
     * 获取所有好友表信息
     * @return
     */
    List<FriendInformation> getAllFriendInfo();

    /**
     * 获取所有用户location信息
     * @return
     */
    List<UserLocation> getAllUserLocation();
}
