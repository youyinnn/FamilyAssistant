package dao.DaoImpl;

import dao.DaoInterface.PageDao;
import db.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/5/12
 */
public class PageDaoImpl<T> implements PageDao<T> {

    private static QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<T> currentPageList(String tableName, int pageNo, int pageSize,Class tClass) {

        List<T> list = null;

        String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM "+tableName+" LIMIT ?, ?";

        String sql2 = "SELECT FOUND_ROWS()";

        Connection connection = null;

        try {
            connection = DBUtils.getConn();

            list = queryRunner.query(connection, sql, new BeanListHandler<T>(tClass), (pageNo - 1) * pageSize, pageSize);

            Object query = queryRunner.query(connection, sql2, new ScalarHandler<>());

            list.add((T) query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
