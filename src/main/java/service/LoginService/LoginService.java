package service.LoginService;

import dao.DaoImpl.LoginSystemDaoImpl;
import model.User;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
public class LoginService {

    private LoginService(){}

    public static User loginHandler(String username, String password){

        return LoginSystemDaoImpl.getInstance().login(username,password);
    }
}
