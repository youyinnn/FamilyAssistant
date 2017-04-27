package controller.UserServiceController;

import com.alibaba.fastjson.JSON;
import db.Table_User;
import model.FriendInformation;
import service.UserService.GetFriendsInfoService;

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
 * @date: 2017/2/21
 */
@WebServlet("/us/getFriendsInfo")
public class GetFriendsInfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int u_id = Integer.parseInt(req.getParameter(Table_User.COLUMN_ID));

        ArrayList<FriendInformation> u_friends_info = GetFriendsInfoService.getFriendsInfoHandler(u_id);

        String u_friend_info_json = JSON.toJSONString(u_friends_info);

        resp.getWriter().println(u_friend_info_json);
    }
}
