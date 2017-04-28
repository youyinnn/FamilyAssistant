package db;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/13
 */
public class DBUtils {

    private static DataSource dataSource = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtils.class);

    static {
        Properties properties = new Properties();
        Properties syspro = System.getProperties();
        String os_name = syspro.getProperty("os.name");
        InputStream inputStream;
        if (os_name.contains("Windows")){
            inputStream = DBUtils.class.getClassLoader().getResourceAsStream("wdbcp.properties");
        }else {
            inputStream = DBUtils.class.getClassLoader().getResourceAsStream("ldbcp.properties");
        }
        try {
            properties.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            LOGGER.error("Get properties error !",e);
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() throws SQLException {
        LOGGER.info("Get connection !");
        return dataSource.getConnection();
    }

    public static Connection getConn(String requestUrl) throws SQLException {
        LOGGER.info("Get conn for : [#] "+requestUrl+" [#] !");
        return dataSource.getConnection();
    }

    public static void release(Connection connection){
        if (connection != null){
            try {
                LOGGER.info("Close connection !");
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Release connection error !",e);
                throw new RuntimeException(e);
            }
        }
    }

    public static void release(Connection connection , String requestUrl){
        if (connection != null){
            try {
                LOGGER.info("Close conn from : [#] "+requestUrl+" [#] !");
                connection.close();
            }catch (SQLException e) {
                LOGGER.error("Release conn from : [#] "+requestUrl+" [#] error !",e);
                throw new RuntimeException(e);
            }
        }
    }

    public static void release(ResultSet resultSet, Statement statement){
        try {
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Release resultSet error !",e);
            throw new RuntimeException(e);
        }

        try {
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Release statement error !",e);
            throw new RuntimeException(e);
        }
    }

}
