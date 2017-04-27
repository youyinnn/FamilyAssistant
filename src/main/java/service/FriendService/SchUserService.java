package service.FriendService;

import dao.DaoImpl.FriendSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class SchUserService {

    private SchUserService(){}

    public static String schUserHandler(String username){

        return FriendSystemDaoImpl.getInstance().searchUserInfo(username);
    }
}
