package service.LoginService;


import dao.DaoImpl.LoginSystemDaoImpl;

import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
public class SignInService {

    private SignInService(){}

    public static boolean signInHandler(Map<String,Object> fieldMap){

        return LoginSystemDaoImpl.getInstance().signIn(fieldMap);
    }
}
