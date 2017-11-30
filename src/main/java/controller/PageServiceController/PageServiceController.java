package controller.PageServiceController;

import web.PageManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/5/14
 */
@WebServlet("/pg/usPg")
public class PageServiceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PageManager pageManager = (PageManager) req.getSession().getAttribute("pageManager");

        Integer pageTo = Integer.valueOf(req.getParameter("pageTo"));

        pageManager.goCertainPage(pageTo);

        req.getRequestDispatcher(req.getContextPath()+"/view/allUserInfo.jsp").forward(req,resp);
    }
}
