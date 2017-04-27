package service.ManagerService;

import dao.DaoImpl.SystemManagerDaoImpl;
import model.User;

import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
public class GetAllUserInfoService {

    private GetAllUserInfoService(){}

    public static List<User> getAllUserInfoHandler(){
        return SystemManagerDaoImpl.getInstance().getAllUserInfo();
    }
}
