package controller.UserServiceController;

import db.Table_Location;
import service.UserService.LocationService;

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
@WebServlet("/us/location")
public class LocationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer u_id = Integer.valueOf(req.getParameter(Table_Location.COLUMN_ID));

        String longitude = req.getParameter("longitude");

        String latitude = req.getParameter("latitude");

        String u_location = longitude+"&"+latitude;

        String friend_locations_list_json = LocationService.locationHandler(u_id, u_location);

        resp.getWriter().print(friend_locations_list_json);
    }
}
