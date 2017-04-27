package dao.DaoInterface;

import model.FriendInformation;

import java.util.ArrayList;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public interface UserSystemDao {

    /**
     * 更改密码
     * @param username
     * @param newPassword
     * @return
     */
    boolean changePassword(String username,String newPassword);

    /**
     * 更改用户信息
     * @param fieldMap
     * @return
     */
    boolean changeUserInformation(Map<String,Object> fieldMap);

    /**
     * 更改好友信息
     * @param fieldMap
     * @return
     */
    boolean changeFriendInformation(Map<String,Object> queryMap,Map<String,Object> fieldMap);

    /**
     * 更改用户头像
     * @param fieldMap
     * @return
     */
    boolean changePortrait(Map<String,Object> fieldMap);

    /**
     * 单个好友信息展示
     * @param id
     * @return
     */
    String showFriendInformation(int id);

    /**
     * 获取用户所有好友的location
     * @param u_id
     * @param u_location
     * @return
     */
    String getLocation(int u_id,String u_location);

    /**
     * 修改关注人
     * @param u_id
     * @param care_id
     * @return
     */
    boolean changeCare(int u_id, int care_id);

    /**
     * 移除关注人
     * @param u_id
     * @return
     */
    boolean removeCare(int u_id);

    /**
     * 了解被谁关心
     * @param u_id
     * @return
     */
    int showCareByWho(int u_id);

    /**
     * 获取好友列表
     * @param u_id
     * @return
     */
    ArrayList<Integer> getFriendList(int u_id);

    /**
     * 获取所有好友信息
     * @param u_id
     * @return
     */
    ArrayList<FriendInformation> getFriendsInfo(int u_id);
}
