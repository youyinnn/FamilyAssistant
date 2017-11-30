package web;

import dao.DaoImpl.PageDaoImpl;
import dao.DaoInterface.PageDao;

import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/5/12
 */
public class PageManager<T> {

    //所有记录数
    private int totalItemNumbers;

    //所有记录能分出的总页数
    private int totalItemPageNumbers;

    //一页显示的记录数
    private int pageSize ;

    //一个页组的页的数量
    private int pageGroupSize ;

    //所有页数能分出的页的页组数
    private int pageGroupNumber;

    //当前所在的页组
    private int currentPageGroup;

    //需要分页的表
    private String tableName;

    //....
    private Class tClass;

    //当前的页
    private Page<T> currentPage;

    public int getTotalItemNumbers() {
        return totalItemNumbers;
    }

    public int getTotalItemPageNumbers() {
        return totalItemPageNumbers;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageGroupSize() {
        return pageGroupSize;
    }

    public int getPageGroupNumber() {
        return pageGroupNumber;
    }

    public int getCurrentPageGroup() {
        return currentPageGroup;
    }

    public Page<T> getCurrentPage() {
        return currentPage;
    }

    public PageManager(String tableName, Class tClass , int pageSize , int pageGroupSize) {

        this.tableName = tableName;
        this.tClass = tClass;
        this.pageSize = pageSize;
        this.pageGroupSize = pageGroupSize;

        //初始化时所在的页 默认为第一页
        this.currentPage = goFirstPage();

        //获取所有记录数
        this.totalItemNumbers = currentPage.getTotalItemNumbers();

        //总共分出来的页数 所有记录数/每页显示的记录数
        totalItemPageNumbers = totalItemNumbers / pageSize ;

        if ((totalItemNumbers % pageSize) >= 1)
            totalItemPageNumbers++;

        //所有页数分成的页组数 = 所有页数 / 每个页组所包含的页数
        pageGroupNumber = totalItemPageNumbers / pageGroupSize ;

        if ((totalItemPageNumbers % pageGroupSize) >= 1)
            pageGroupNumber ++;

        //初始化当前页组数
        currentPageGroup = 1 ;
    }

    public boolean isLowLimit(){

        int pageNo = currentPage.getPageNo();

        return pageNo == 1 ;
    }

    public Boolean isHighLimit(){

        int pageNo = currentPage.getPageNo();

        return pageNo == totalItemPageNumbers;
    }


    public Page<T> goFirstPage(){

        int pageNoTo = 1;

        currentPageGroup = 1;

        currentPage = new Page(pageNoTo,tableName,pageSize,tClass);

        return currentPage;
    }

    public Page<T> goNextPage(){

        int pageNoTo = currentPage.getPageNo()+1;

        currentPageGroup = reSetCurrentPageGroup(pageNoTo);

        currentPage = new Page(pageNoTo,tableName,pageSize,tClass);

        return currentPage;
    }

    public Page<T> goPrevPage() {

        int pageNoTo = currentPage.getPageNo()-1;

        currentPageGroup = reSetCurrentPageGroup(pageNoTo);

        currentPage = new Page(pageNoTo,tableName,pageSize,tClass);

        return currentPage;
    }

    public Page<T> goCertainPage(int pageNumber) {

        currentPageGroup = reSetCurrentPageGroup(pageNumber);

        currentPage = new Page(pageNumber,tableName,pageSize,tClass);

        return currentPage;
    }

    public Page<T> goLastPage(){

        currentPageGroup = pageGroupNumber;

        currentPage = new Page(totalItemPageNumbers,tableName,pageSize,tClass);

        return currentPage;
    }

    private int reSetCurrentPageGroup(int pageNoTo){
        return (pageNoTo+pageGroupSize-1)/pageGroupSize;
    }

    @Override
    public String toString() {
        return "PageManager{" +
                "totalItemNumbers=" + totalItemNumbers +
                ", totalItemPageNumbers=" + totalItemPageNumbers +
                ", pageSize=" + pageSize +
                ", pageGroupSize=" + pageGroupSize +
                ", pageGroupNumber=" + pageGroupNumber +
                ", currentPageGroup=" + currentPageGroup +
                ", tableName='" + tableName + '\'' +
                ", tClass=" + tClass +
                ", currentPage=" + currentPage +
                '}';
    }

    public class Page<T> {

        //当前页的页数
        private int pageNo;

        //当前页的 List
        private List<T> list;

        //所有的记录数
        private int totalItemNumbers;

        int getTotalItemNumbers() {
            return totalItemNumbers;
        }

        public List<T> getList() {
            return list;
        }

        public int getPageNo() {
            return pageNo;
        }

        Page(int pageNo, String tableName, int pageSize, Class tClass) {

            this.pageNo = pageNo;

            PageDao pageDao = new PageDaoImpl();

            List<T> list1 = pageDao.currentPageList(tableName,pageNo,pageSize,tClass);

            Object obj = list1.get(list1.size()-1);

            String x = obj.toString();

            this.totalItemNumbers = Integer.parseInt(x);

            list1.remove(list1.size()-1);

            list = list1;
        }

        @Override
        public String toString() {
            return "Page{" +
                    "pageNo=" + pageNo +
                    //", list=" + list +
                    ", totalItemNumbers=" + totalItemNumbers +
                    '}';
        }
    }
}
