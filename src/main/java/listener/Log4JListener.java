package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/18
 */
public class Log4JListener implements ServletContextListener {

    private static final String log4jdirkey = "log4jdir";

    public void contextDestroyed(ServletContextEvent servletcontextevent) {
        System.getProperties().remove(log4jdirkey);
    }

    public void contextInitialized(ServletContextEvent servletcontextevent) {
        URL classpath = Log4JListener.class.getClassLoader().getResource("");
        System.out.println(classpath);
        String log4jdir = servletcontextevent.getServletContext().getRealPath("/");
        System.out.println("log4jdir:"+log4jdir);
        System.setProperty(log4jdirkey, log4jdir);
    }
}
