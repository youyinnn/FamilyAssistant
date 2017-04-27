package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
public class SoCareByService {

    private SoCareByService(){}

    public static int soCareByHandler(int u_id){

        return UserSystemDaoImpl.getInstance().showCareByWho(u_id);
    }
}
