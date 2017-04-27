package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/4
 */
public class BusinessFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String equip = request.getParameter("equip");
        if (equip == null){
            if (request.getContentType().contains("multipart/form-data")){
                String request_url = String.valueOf(request.getRequestURL());
                if (request_url.contains("/us/cgPortrait") || request_url.contains("/lg/signIn")){
                    chain.doFilter(request,response);
                }
            }else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }else {
            if (equip.equals("NewThreadAndroid")){
                chain.doFilter(request,response);
            }else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }
    }
}
