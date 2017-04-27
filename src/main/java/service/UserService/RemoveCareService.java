package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
public class RemoveCareService {

    private RemoveCareService(){}

    public static boolean removeCareHandler(int u_id){

        return UserSystemDaoImpl.getInstance().removeCare(u_id);
    }
}
