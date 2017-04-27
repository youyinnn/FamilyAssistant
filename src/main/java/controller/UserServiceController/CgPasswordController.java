package controller.UserServiceController;

import db.Table_User;
import service.UserService.CgPasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/17
 */
@WebServlet("/us/cgPassword")
public class CgPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(Table_User.COLUMN_USERNAME);
        String newPassword = req.getParameter(Table_User.COLUMN_PASSWORD);

        boolean finishMark = CgPasswordService.cgPasswordHandler(username,newPassword);

        resp.getWriter().print(finishMark);
    }
}
