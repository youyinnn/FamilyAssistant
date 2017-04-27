package dao.DaoInterface;

import model.User;

import java.util.Map;

/**
 * Created by youyinnn on 2017/2/16.
 */
public interface LoginSystemDao {

    /**
     * 登录服务
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 注册服务
     * @param fieldMap
     * @return
     */
    boolean signIn(Map<String,Object> fieldMap);

    /**
     * 验证服务
     * @param username
     * @return
     */
    boolean verify(String username);
}
