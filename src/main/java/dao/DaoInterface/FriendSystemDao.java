package dao.DaoInterface;

/**
 * Created by youyinnn on 2017/2/17.
 */
public interface FriendSystemDao {

    /**
     * 添加好友
     * @param u_id
     * @param f_id
     * @return
     */
    boolean addFriend(int u_id,int f_id);

    /**
     * 删除好友
     * @param u_id
     * @param f_id
     * @return
     */
    boolean deleteFriend(int u_id,int f_id);

    /**
     * 搜索用户信息
     * @param username
     * @return
     */
    String searchUserInfo(String username);
}
