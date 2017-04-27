package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public class CgUserInfoService {

    private CgUserInfoService(){}

    public static boolean cgUserInfoHandler(Map<String,Object> fieldMap){

        return UserSystemDaoImpl.getInstance().changeUserInformation(fieldMap);
    }
}
