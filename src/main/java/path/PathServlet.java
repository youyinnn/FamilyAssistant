package path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/3
 */
@WebServlet("/path")
public class PathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();

        while (enumeration.hasMoreElements()){
            resp.getWriter().println(enumeration.nextElement());
        }

        String userhome = System.getProperty("user.home");
        resp.getWriter().println(userhome);
        String catalinahome = System.getProperty("catalina.home");
        resp.getWriter().println(catalinahome);
        String classpath = System.getProperty("java.class.path");
        resp.getWriter().println(classpath);
    }
}
