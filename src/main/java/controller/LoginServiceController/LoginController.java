package controller.LoginServiceController;

import com.alibaba.fastjson.JSON;
import db.Table_User;
import model.User;
import service.LoginService.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
@WebServlet("/lg/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter(Table_User.COLUMN_USERNAME);
        String password = req.getParameter(Table_User.COLUMN_PASSWORD);

        User user = LoginService.loginHandler(username,password);

        String user_json = JSON.toJSONString(user);

        resp.getWriter().print(user_json);
    }
}
