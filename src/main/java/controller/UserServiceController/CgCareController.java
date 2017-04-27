package controller.UserServiceController;

import db.Table_User;
import service.UserService.CgCareService;

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
@WebServlet("/us/changeCare")
public class CgCareController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int u_id = Integer.parseInt(req.getParameter(Table_User.COLUMN_ID));

        int care_id = Integer.parseInt(req.getParameter(Table_User.COLUMN_CARE));

        boolean finishMark = CgCareService.changeCareHandler(u_id,care_id);

        resp.getWriter().print(finishMark);
    }
}
