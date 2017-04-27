package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
public class CgPasswordService {

    private CgPasswordService(){}

    public static boolean cgPasswordHandler(String username,String newpassword){

        return UserSystemDaoImpl.getInstance().changePassword(username,newpassword);
    }

}
