package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
public class LocationService {

    private LocationService(){}

    public static String locationHandler(int u_id, String u_location){

        return UserSystemDaoImpl.getInstance().getLocation(u_id,u_location);
    }
}
