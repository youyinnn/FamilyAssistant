package controller.UserServiceController;

import service.UserService.CgUserInfoService;

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
 * @date: 2017/2/17
 */
@WebServlet("/us/cgUserInfo")
public class CgUserInfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map =  req.getParameterMap();

        Map<String,Object> fieldMap = new HashMap<>();

        for (Map.Entry<String, String[]> entry : map.entrySet()){
            fieldMap.put(entry.getKey(),entry.getValue()[0]);
        }

        fieldMap.remove("equip");

        boolean finishMark = CgUserInfoService.cgUserInfoHandler(fieldMap);

        resp.getWriter().print(finishMark);
    }
}
