package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/4
 */
public class BrowserEquipFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        if (session.getAttribute("session_id") == null){
            String req_adminstrator = request.getParameter("adminstrator");
            String password = request.getParameter("password");
            if (req_adminstrator == null && password == null){
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                assert req_adminstrator != null;
                if (req_adminstrator.equals(context.getInitParameter("adminstrator")) && password.equals(context.getInitParameter("adminpassword"))){
                    session.setAttribute("session_id",session.getId());
                    chain.doFilter(request,response);
                }else {
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }
            }
        }else {
            if (session.getAttribute("session_id").equals(session.getId()))
                chain.doFilter(request,response);
        }
    }
}
