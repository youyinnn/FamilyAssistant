package controller.FriendServiceController;

import db.Table_User;
import service.FriendService.SchUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by youyinnn on 2017/2/18.
 */
@WebServlet("/fs/searchUser")
public class SchUserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter(Table_User.COLUMN_USERNAME);

        String info_json = SchUserService.schUserHandler(username);

        resp.getWriter().print(info_json);
    }
}
