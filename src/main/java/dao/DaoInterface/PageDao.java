package dao.DaoInterface;

import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/5/12
 */
public interface PageDao<T> {

    //无条件获取当前页的所有记录
    List<T> currentPageList(String tableName ,int pageNo , int pageSize,Class tClass);

}
