package service.LoginService;

import dao.DaoImpl.LoginSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
public class VerifyService {

    private VerifyService(){}

    public static boolean verifyHandler(String username){

        return LoginSystemDaoImpl.getInstance().verify(username);
    }
}
