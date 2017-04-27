package controller.FriendServiceController;

import service.FriendService.AddFriendService;

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
@WebServlet("/fs/addFriend")
public class AddFriendController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s_u_id = req.getParameter("u_id");
        String s_f_id = req.getParameter("f_id");

        int u_id = new Integer(s_u_id);

        int f_id = new Integer(s_f_id);

        boolean finishMark = AddFriendService.addFriendHandler(u_id,f_id);

        resp.getWriter().print(finishMark);
    }
}
