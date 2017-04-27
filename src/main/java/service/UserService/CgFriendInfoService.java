package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class CgFriendInfoService {

    private CgFriendInfoService(){}

    public static boolean cgFriendInfoHandler(Map<String,Object> queryMap,Map<String,Object> fieldMap){

        return UserSystemDaoImpl.getInstance().changeFriendInformation(queryMap,fieldMap);
    }
}
