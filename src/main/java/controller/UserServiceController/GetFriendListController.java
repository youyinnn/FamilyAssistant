package controller.UserServiceController;

import com.alibaba.fastjson.JSON;
import db.Table_User;
import service.UserService.GetFriendLIstService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
@WebServlet("/us/getFriendList")
public class GetFriendListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int u_id = Integer.parseInt(req.getParameter(Table_User.COLUMN_ID));

        ArrayList<Integer> friend_list = GetFriendLIstService.getFriendListHandler(u_id);

        String friend_list_json = JSON.toJSONString(friend_list);

        resp.getWriter().print(friend_list_json);
    }
}
