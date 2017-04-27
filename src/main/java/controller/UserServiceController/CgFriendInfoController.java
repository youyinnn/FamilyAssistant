package controller.UserServiceController;

import db.Table_Friend_List;
import service.UserService.CgFriendInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
@WebServlet("/us/changeFriendInfo")
public class CgFriendInfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map =  req.getParameterMap();
        Map<String,Object> fieldMap = new HashMap<>();
        Map<String,Object> queryMap = new HashMap<>();

        for (Map.Entry<String, String[]> entry : map.entrySet()){
            if ((entry.getKey().equals(Table_Friend_List.COLUMN_ID))||
                    (entry.getKey().equals(Table_Friend_List.COLUMN_FRIEND_ID))){
                queryMap.put(entry.getKey(),entry.getValue()[0]);
            }else {
                fieldMap.put(entry.getKey(),entry.getValue()[0]);
            }
        }

        fieldMap.remove("equip");

        boolean finishMark = CgFriendInfoService.cgFriendInfoHandler(queryMap,fieldMap);

        resp.getWriter().print(finishMark);

    }
}
