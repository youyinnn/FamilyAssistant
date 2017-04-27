package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;
import model.FriendInformation;

import java.util.ArrayList;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
public class GetFriendsInfoService {

    private GetFriendsInfoService(){}

    public static ArrayList<FriendInformation> getFriendsInfoHandler(int u_id){

        return UserSystemDaoImpl.getInstance().getFriendsInfo(u_id);
    }
}
