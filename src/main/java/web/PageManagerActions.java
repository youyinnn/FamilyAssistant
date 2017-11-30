package web;

/**
 * Created by youyinnn on 2017/5/13.
 */
public interface PageManagerActions {

    PageManager.Page goFirstPage();

    PageManager.Page goLastPage();

    PageManager.Page goNextPage();

    PageManager.Page goPrevPage();

    PageManager.Page goCertainPage(int pageNumber);
}
