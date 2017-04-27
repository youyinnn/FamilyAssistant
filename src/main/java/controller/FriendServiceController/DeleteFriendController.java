package controller.FriendServiceController;

import service.FriendService.DeleteFriendService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
@WebServlet("/fs/deleteFriend")
public class DeleteFriendController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int u_id = Integer.parseInt(req.getParameter("u_id"));
        int f_id = Integer.parseInt(req.getParameter("f_id"));

        boolean finishMark = DeleteFriendService.deleteFriendHandler(u_id,f_id);

        resp.getWriter().print(finishMark);
    }
}
