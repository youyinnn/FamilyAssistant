package controller.SysManagerController;

import model.User;
import service.ManagerService.GetAllUserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/21
 */
@WebServlet("/ss/getAllUserInfo")
public class GetAllUserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> all_user_info = GetAllUserInfoService.getAllUserInfoHandler();

        for (User user : all_user_info){
            resp.getWriter().println(user);
            resp.getWriter().println();
        }
    }
}
