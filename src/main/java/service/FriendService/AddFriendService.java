package service.FriendService;

import dao.DaoImpl.FriendSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public class AddFriendService {

    private AddFriendService(){}

    public static boolean addFriendHandler(int u_id,int f_id){

        return FriendSystemDaoImpl.getInstance().addFriend(u_id,f_id);
    }
}
