package controller.SysManagerController;

import model.UserLocation;
import service.ManagerService.GetAllLocationService;

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
@WebServlet("/ss/getAllLocation")
public class GetAllLocationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserLocation> all_user_location = GetAllLocationService.getAllLocationHandler();

        for (UserLocation userLocation : all_user_location){
            resp.getWriter().println(userLocation);
            resp.getWriter().println();
        }
    }
}
