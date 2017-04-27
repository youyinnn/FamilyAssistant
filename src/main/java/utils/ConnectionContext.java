package utils;

import java.sql.Connection;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/13
 */
public class ConnectionContext {

    private ConnectionContext(){}

    private static ConnectionContext instance = new ConnectionContext();

    public static ConnectionContext getInstance() {
        return instance;
    }

    private ThreadLocal<Connection> connectionThreadLocal =
            new ThreadLocal<>();

    public void bind(Connection connection){
        connectionThreadLocal.set(connection);
    }

    public Connection get(){
        return connectionThreadLocal.get();
    }

    public void remove(){
        connectionThreadLocal.remove();
    }
}
