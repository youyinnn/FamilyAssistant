package controller.SysManagerController;

import model.FriendInformation;
import service.ManagerService.GetAllFriendInfoService;

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
@WebServlet("/ss/getAllFriendInfo")
public class GetAllFriendInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FriendInformation> all_friend_info = GetAllFriendInfoService.getAllFriendInfoHandler();

        for (FriendInformation friendInformation : all_friend_info){
            resp.getWriter().println(friendInformation);
            resp.getWriter().println();
        }
    }
}
