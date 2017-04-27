package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

import java.util.ArrayList;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
public class GetFriendLIstService {

    private GetFriendLIstService(){}

    public static ArrayList<Integer> getFriendListHandler(int u_id){

        return UserSystemDaoImpl.getInstance().getFriendList(u_id);
    }
}
