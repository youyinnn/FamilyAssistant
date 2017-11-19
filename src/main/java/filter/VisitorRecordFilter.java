package filter;

import org.apache.log4j.NDC;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/22
 */
public class VisitorRecordFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String remoteAddr = request.getRemoteAddr();

        NDC.push(remoteAddr);

        chain.doFilter(request,response);

        NDC.pop();
    }

    @Override
    public void destroy() {

        NDC.remove();

        super.destroy();
    }
}
