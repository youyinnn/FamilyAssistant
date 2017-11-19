package dao.DaoInterface;

import java.util.List;
import java.util.Map;

/**
 * Created by youyinnn on 2017/2/11.
 */
public interface DAO<T> {


    /**
     * 返回tableName表下所有字段的所有记录
     * @param tableName : 要查询的表名
     * @param tClass : 要返回的list包含的类的类别
     * @return : 返回符合查询条件的list
     */
    List<T> queryList(String tableName, Class<T> tClass);

    /**
     * 返回tableName表下query_columns_list几个字段的所有记录
     * @param tableName : 要查询的表名
     * @param tClass : 要返回的list包含的类的类别
     * @param query_columns_list : 需要查询的列的list
     * @return : 返回符合查询条件的list
     */
    List<T> queryList(String tableName, Class<T> tClass,List<String> query_columns_list);

    /**
     * 查询tableName表中在queryKey字段值为begin到end之间的所有字段
     * @param tableName : 要查询的表名
     * @param tClass : 要返回的list包含的类的类别
     * @param query_condition : 作为查询条件的列名
     * @param begin : 条件范围下限
     * @param end : 条件范围上限
     * @return : 返回符合查询条件的list
     */
    List<T> queryList(String tableName, Class<T> tClass, String query_condition, int begin, int end);


    /**
     * 查询tableName表中在query_condition字段值为begin到end之间的query_columns_list字段
     * @param tableName : 要查询的表名
     * @param tClass : 要返回的list包含的类的类别
     * @param query_condition : 作为查询条件的列名
     * @param begin : 条件范围下限
     * @param end : 条件范围上限
     * @param query_columns_list : 需要查询的列的list
     * @return : ...
     */
    List<T> queryList(String tableName, Class<T> tClass, String query_condition, int begin, int end, List<String> query_columns_list);


    /**
     * 查询tableName表中在query_condition字段为指定的多个keys时的所有字段
     * @param tableName : ...
     * @param tClass : ...
     * @param query_condition : 作为查询条件的列名
     * @param values : 指定的若干条件值
     * @return : ...
     */
    List<T> queryList(String tableName, Class<T> tClass, String query_condition, List<?> values);

    /**
     * 查询tableName表中在query_condition字段为指定的多个keys时的所有字段
     * @param tableName : ...
     * @param tClass : ...
     * @param query_condition : 作为查询条件的列名
     * @param values : 指定的若干条件值
     * @return : ...
     */
    List<T> queryList(String tableName, Class<T> tClass, String query_condition, List<?> values,List<String> query_columns_list);

    /**
     * 多条件查询：查询tableName下和condition_value_map中键值对匹配的所有字段的记录
     * @param tableName ：...
     * @param tClass ：要返回的list包含的类的类别
     * @param condition_value_map ：作为查询条件列和条件值的键值对（要作为条件的列-条件的值）map
     * @return ：...
     */
    List<T> queryList(String tableName, Class<T> tClass,Map<String,Object> condition_value_map);

    /**
     * 在tableName表上查询当列query_condition的值为condition_value时的query_columns_list这几列的信息 封装成tClass对象返回
     * @param tableName ：要查询的表名
     * @param query_condition ：作为查询条件的列
     * @param condition_value ：查询条件的值
     * @param query_columns_list ：需要查询的列的list
     * @param tClass ：...
     * @return ：...
     */
    T queryOne(String tableName, String query_condition,Object condition_value, List<String> query_columns_list,Class<T> tClass);

    /**
     * 在tableName表查询和condition_value_map匹配的有限列query_columns_list的单个记录
     * @param tableName ：...
     * @param query_columns_list ：要查询的有限列的list
     * @param condition_value_map ：作为查询条件列和条件值的键值对（要作为条件的列-条件的值）map
     * @return ：...
     */
    T queryOne(String tableName, List<String> query_columns_list,Map<String,Object> condition_value_map,Class<T> tClass);

    /**
     * 基础的更新操作：INSERT、DELETE、UPDATE
     * @param sql ：sql语句
     * @param objects ：填充占位符的参数
     * @return ：更新操作影响到
     */
    int update(String sql, Object... objects);

    /**
     * 插入信息
     * @param tableName ： 要插入的表的表名
     * @param fieldMap ：要插入的数据键值对
     * @return ：返回操作成功或失败
     */
    boolean insertEntity(String tableName, Map<String,Object> fieldMap);

    /**
     * 更新tableName表下的当query_condition为value的fieldMap各个字段
     * @param tableName ：...
     * @param query_condition ：作为查询条件的列
     * @param value ：条件的值
     * @param fieldMap ：更新的键值对（要更新的列-更新值）
     * @return ：...
     */
    boolean updateEntity(String tableName, String query_condition, Object value ,Map<String,Object> fieldMap);


    /**
     * 更新tableName表下的以condition_value_map键值对为多个查询条件匹配的记录的fieldMap各个字段
     * @param tableName ：...
     * @param condition_value_map ：作为查询条件列和条件值的键值对（要作为条件的列-条件的值）map
     * @param fieldMap ：...
     * @return ：...
     */
    boolean updateEntity(String tableName, Map<String,Object> condition_value_map, Map<String,Object> fieldMap);

    /**
     * 根据多个键值对条件删除信息
     * @param tableName ：...
     * @param condition_value_map ：作为查询条件列和条件值的键值对（要作为条件的列-条件的值）map
     * @return ：...
     */
    boolean deleteEntity(String tableName, Map<String,Object> condition_value_map);

    /**
     * 查询表tableName对应queryKey为keyValue的列column的值
     * @param tableName : ...
     * @param query_condition : ...
     * @param condition_value : ...
     * @param column : ...
     * @return : ...
     */
    Object getValue(String tableName ,String query_condition, Object condition_value,String column);

}
