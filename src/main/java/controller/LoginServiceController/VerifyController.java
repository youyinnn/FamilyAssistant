package controller.LoginServiceController;

import db.Table_User;
import service.LoginService.VerifyService;

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
@WebServlet("/lg/verify")
public class VerifyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter(Table_User.COLUMN_USERNAME);

        boolean finishMark = VerifyService.verifyHandler(username);

        resp.getWriter().print(finishMark);
    }
}