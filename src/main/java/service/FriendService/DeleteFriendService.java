package service.FriendService;

import dao.DaoImpl.FriendSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class DeleteFriendService {

    private DeleteFriendService(){}

    public static boolean deleteFriendHandler(int u_id,int f_id){
        return FriendSystemDaoImpl.getInstance().deleteFriend(u_id,f_id);
    }

}
