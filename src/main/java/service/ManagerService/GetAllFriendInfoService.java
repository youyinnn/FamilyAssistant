package service.ManagerService;

import dao.DaoImpl.SystemManagerDaoImpl;
import model.FriendInformation;

import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
public class GetAllFriendInfoService {

    private GetAllFriendInfoService(){}

    public static List<FriendInformation> getAllFriendInfoHandler(){

        return SystemManagerDaoImpl.getInstance().getAllFriendInfo();
    }
}
