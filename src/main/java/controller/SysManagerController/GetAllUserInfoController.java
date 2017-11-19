package controller.SysManagerController;

import db.Table_User;
import model.User;
import web.PageManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
@WebServlet("/ss/getAllUserInfo")
public class GetAllUserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PageManager pageManager = new PageManager(Table_User.TABLE_NAME, User.class,3,3);

        HttpSession session = req.getSession();

        session.setAttribute("pageManager",pageManager);

        resp.sendRedirect(req.getContextPath()+"/pg/usPg?pageTo=1");
    }
}
