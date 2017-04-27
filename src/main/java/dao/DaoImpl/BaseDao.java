package dao.DaoImpl;

import dao.DaoInterface.DAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CollectionUtil;
import utils.ConnectionContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/13
 */
public class BaseDao<T> implements DAO<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);

    private static QueryRunner queryRunner = new QueryRunner();

    private BaseDao(){}

    private static BaseDao instance = new BaseDao();

    public static BaseDao getInstance() {
        return instance;
    }


    @Override
    public List<T> queryList(String tableName, Class<T> tClass) {
        List<T> list;
        String sql = "SELECT * FROM "+tableName;
        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();

            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list for all message failure !",e);
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<T> queryList(String tableName, Class<T> tClass, List<String> query_columns_list) {
        List<T> list;
        String sql = "SELECT ";
        StringBuffer str_query_columns = new StringBuffer();
        for (String column : query_columns_list){
            str_query_columns.append(column).append(",");
        }
        str_query_columns.deleteCharAt(str_query_columns.lastIndexOf(","));
        sql += str_query_columns+" From "+tableName;

        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();
            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list for several columns failure !",e);
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<T> queryList(String tableName, Class<T> tClass, String query_condition, int begin, int end) {
        List<T> list;
        String sql = "SELECT * FROM "+tableName+" WHERE "+query_condition+" >= "+begin+" AND "+query_condition+" <= "+end;

        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();

            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list for all message in range failure !",e);
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<T> queryList(String tableName, Class<T> tClass, String query_condition, int begin, int end, List<String> query_columns_list) {
        List<T> list;
        String sql = "SELECT ";
        StringBuffer str_query_columns = new StringBuffer();
        for (String column : query_columns_list){
            str_query_columns.append(column).append(",");
        }
        str_query_columns.deleteCharAt(str_query_columns.lastIndexOf(","));

        sql += str_query_columns+" FROM "+tableName+" WHERE "+query_condition+" >= "+begin+" AND "+query_condition+" <= "+end;

        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();

            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list for several columns in range failure !",e);
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<T> queryList(String tableName, Class<T> tClass, String query_condition, List<?> values) {
        List<T> list;
        String str_values = values.toString().substring(1,values.toString().length()-1);
        String sql = "SELECT * FROM "+tableName+" WHERE "+query_condition+" in("+str_values+")";

        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();
            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list for all message in several appointed keys failure !",e);
            throw new RuntimeException(e);
        }
        return list;
    }

    @SuppressWarnings("StringBufferMayBeStringBuilder")
    @Override
    public List<T> queryList(String tableName, Class<T> tClass, String query_condition, List<?> values, List<String> query_columns_list) {
        List<T> list;
        String str_values = values.toString().substring(1,values.toString().length()-1);
        StringBuffer str_query_columns = new StringBuffer();
        for (String column : query_columns_list){
            str_query_columns.append(column).append(",");
        }

        String sql = "SELECT "+str_query_columns.deleteCharAt(str_query_columns.lastIndexOf(","))
                +" FROM "+tableName+" WHERE "+query_condition+" in("+str_values+")";

        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();
            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list for all message in several appointed keys failure !",e);
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<T> queryList(String tableName, Class<T> tClass, Map<String, Object> condition_value_map) {
        List<T> list;
        String sql = "SELECT * FROM "+tableName+" WHERE ";
        StringBuffer str_condition_value = new StringBuffer();
        for (Map.Entry<String,Object> entry : condition_value_map.entrySet()){
            str_condition_value.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" AND ");
        }

        str_condition_value.delete(str_condition_value.lastIndexOf("A"),str_condition_value.length());

        sql += str_condition_value;

        Connection connection;

        try {
            connection = ConnectionContext.getInstance().get();
            list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Query list by conditions failure !",e);
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public T queryOne(String tableName, String query_condition,Object condition_value, List<String> query_columns_list,Class<T> tClass) {
        T entity;
        String sql = "SELECT ";
        StringBuffer str_query_columns = new StringBuffer();
        for (String column : query_columns_list){
            str_query_columns.append(column).append(",");
        }

        str_query_columns.deleteCharAt(str_query_columns.lastIndexOf(","));

        sql += str_query_columns+" FROM "+tableName+" WHERE "+query_condition+" = ?";

        Connection connection;

        try {
            connection = ConnectionContext.getInstance().get();
            entity = queryRunner.query(connection,sql,new BeanHandler<T>(tClass),condition_value);
        } catch (SQLException e) {
            LOGGER.error("Query one failure !",e);
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public T queryOne(String tableName, List<String> query_columns_list, Map<String, Object> condition_value_map,Class<T> tClass) {
        T entity;

        String sql = "SELECT ";
        StringBuffer str_query_columns = new StringBuffer();
        for (String queryColumn : query_columns_list){
            str_query_columns.append(queryColumn).append(",");
        }

        sql += " "+str_query_columns.substring(0,str_query_columns.length()-1)+" FROM "+tableName+" WHERE ";

        StringBuffer str_condition_value = new StringBuffer();
        for (Map.Entry<String,Object> entry : condition_value_map.entrySet()){
            str_condition_value.append(entry.getKey()).append(" = \'").append(entry.getValue()).append("\' AND ");
        }

        sql += str_condition_value.delete(str_condition_value.lastIndexOf("A"),str_condition_value.length());

        Connection connection ;

        try {
            connection = ConnectionContext.getInstance().get();

            entity = queryRunner.query(connection,sql,new BeanHandler<T>(tClass));
        } catch (SQLException e) {
            LOGGER.error("Fail to query one !",e);
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public int update(String sql, Object... objects) {
        int rows;
        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();
            rows = queryRunner.update(connection,sql,objects);
        } catch (SQLException e) {
            LOGGER.error("Update failure !",e);
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public boolean insertEntity(String tableName, Map<String, Object> fieldMap) {
        if (CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("Insert entity failure cause by empty map !");
            return false;
        }

        String sql = "INSERT INTO "+tableName;
        StringBuffer columns = new StringBuffer("(");
        StringBuffer values = new StringBuffer("(");
        for (String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append(",");
            values.append("?,");
        }

        columns.replace(columns.lastIndexOf(","),columns.length(),")");
        values.replace(values.lastIndexOf(","),values.length(),")");

        sql += columns+" VALUES"+values;

        Object[] objects = fieldMap.values().toArray();

        return update(sql,objects) == 1;
    }

    @Override
    public boolean updateEntity(String tableName, String queryKey, Object keyValue, Map<String, Object> fieldMap) {
        if (CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("Update entity failure cause by empty fieldMap !");
            return false;
        }

        String sql = "UPDATE "+tableName+" SET ";
        StringBuffer columns = new StringBuffer();
        for (String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append("=?, ");
        }

        sql += columns.substring(0,columns.lastIndexOf(", "))+ " WHERE "+queryKey+" = \""+keyValue+"\"";

        List<Object> paramList = new ArrayList<>();
        paramList.addAll(fieldMap.values());

        Object[] objects = paramList.toArray();

        return update(sql,objects) == 1;
    }

    @Override
    public boolean updateEntity(String tableName, Map<String, Object> condition_value_map, Map<String, Object> fieldMap) {
        if (CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("Update entity failure cause by empty fieldMap !");
            return false;
        }

        String sql = "UPDATE "+tableName+" SET ";
        StringBuffer columns = new StringBuffer();
        for (String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append("=?, ");
        }

        sql += columns.substring(0,columns.lastIndexOf(", "))+ " WHERE ";

        String queryPart = "";

        for (Map.Entry<String,Object> entry : condition_value_map.entrySet()){
            queryPart += (entry.getKey()+" = "+entry.getValue()+" AND ");
        }

        sql += (queryPart.substring(0,queryPart.length()-4));

        List<Object> paramList = new ArrayList<>();
        paramList.addAll(fieldMap.values());

        Object[] objects = paramList.toArray();

        return update(sql,objects) == 1;
    }

    @Override
    public boolean deleteEntity(String tableName, Map<String,Object> condition_value_map) {
        String sql  = "DELETE FROM "+tableName+" WHERE ";

        String str_condition_value = "";

        for (Map.Entry<String,Object> entry : condition_value_map.entrySet()){
            str_condition_value += (entry.getKey()+" = "+entry.getValue()+" AND ");
        }

        sql += str_condition_value.substring(0,str_condition_value.length()-4);

        return  update(sql) == 1;
    }

    @Override
    public Object getValue(String tableName, String query_condition, Object condition_value, String column) {
        String sql = "SELECT "+column+" FROM "+tableName+" WHERE "+query_condition+" = ?";
        Object value;
        Connection connection;
        try {
            connection = ConnectionContext.getInstance().get();

            value = queryRunner.query(connection,sql,new ScalarHandler<>(),condition_value);
        } catch (SQLException e) {
            LOGGER.error("Get value failure !",e);
            throw new RuntimeException(e);
        }
        return value;
    }
}