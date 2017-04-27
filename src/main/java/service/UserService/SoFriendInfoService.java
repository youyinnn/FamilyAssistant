package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
public class SoFriendInfoService {

    private SoFriendInfoService(){}

    public static String showFriendInfoHandler(int f_id){

        return UserSystemDaoImpl.getInstance().showFriendInformation(f_id);
    }
}
