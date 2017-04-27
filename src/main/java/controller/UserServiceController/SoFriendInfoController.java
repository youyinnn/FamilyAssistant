package controller.UserServiceController;

import db.Table_User;
import service.UserService.SoFriendInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/19
 */
@WebServlet("/us/showFriendInfo")
public class SoFriendInfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int f_id = Integer.parseInt(req.getParameter(Table_User.COLUMN_ID));

        String info_json = SoFriendInfoService.showFriendInfoHandler(f_id);

        resp.getWriter().print(info_json);
    }
}
