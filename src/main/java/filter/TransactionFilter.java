package filter;

import db.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConnectionContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/16
 */
public class TransactionFilter extends HttpFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String requestUrl = request.getRequestURI();

        Connection connection = null;

        try {
            //获取连接
            connection = DBUtils.getConn(requestUrl);

            //开启事务
            connection.setAutoCommit(false);

            //把连接和线程绑定
            ConnectionContext.getInstance().bind(connection);

            //把请求转给Servlet
            chain.doFilter(request,response);

            //提交事务
            connection.commit();
        } catch (Exception e) {
            LOGGER.error("Transaction Opening fail!",e);

            try {
                assert connection != null;
                //回滚事务
                connection.rollback();
            } catch (SQLException e1) {
                LOGGER.error("Rolling back fail !",e1);
                throw new RuntimeException(e);
            }finally {
                //解除绑定
                ConnectionContext.getInstance().remove();

                //关闭连接
                DBUtils.release(connection,requestUrl);
            }
            throw new RuntimeException(e);
        }finally {
            //解除绑定
            ConnectionContext.getInstance().remove();

            //关闭连接
            DBUtils.release(connection,requestUrl);
        }
    }
}
