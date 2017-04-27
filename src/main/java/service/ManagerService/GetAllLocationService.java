package service.ManagerService;

import dao.DaoImpl.SystemManagerDaoImpl;
import model.UserLocation;

import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
public class GetAllLocationService {

    private GetAllLocationService(){}

    public static List<UserLocation> getAllLocationHandler(){

        return SystemManagerDaoImpl.getInstance().getAllUserLocation();
    }
}
