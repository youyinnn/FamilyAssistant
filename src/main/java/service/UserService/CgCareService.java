package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
public class CgCareService {

    private CgCareService(){}

    public static boolean changeCareHandler(int u_id,int care_id){

        return UserSystemDaoImpl.getInstance().changeCare(u_id,care_id);
    }
}
