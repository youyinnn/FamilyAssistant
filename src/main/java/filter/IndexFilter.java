package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/3
 */
public class IndexFilter extends HttpFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("submit")!=null){
            if (request.getParameter("submit").equals("Logout"))
                session.removeAttribute("session_id");
        }

        //如果这个Attribute都是空的 说明之前没人访问过就直接放到index页面
        if (session.getAttribute("session_id") == null){
            LOGGER.info("New visitor !");
            chain.doFilter(request,response);
            return;
        }else {
            String session_id = session.getAttribute("session_id").toString();
            if (session_id.equals(session.getId())){
                response.sendRedirect(request.getContextPath()+"/view/list.jsp");
                return;
            }
        }
        chain.doFilter(request,response);
    }
}
