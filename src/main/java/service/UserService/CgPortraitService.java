package service.UserService;

import dao.DaoImpl.UserSystemDaoImpl;

import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class CgPortraitService {

    private CgPortraitService(){}

    public static boolean cgPortraitHandler(Map<String,Object> fieldMap){

        return UserSystemDaoImpl.getInstance().changePortrait(fieldMap);
    }
}
