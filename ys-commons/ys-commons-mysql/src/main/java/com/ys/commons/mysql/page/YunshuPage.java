package com.ys.commons.mysql.page;

/**
 * 分页工具类 - ThreadLocal用来存储当前请求的Page对象
 */
public class YunshuPage {

    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    /**
     * 设置分页信息
     * @param pageNum
     * @param pageSize
     */
    public static void setPage(Integer pageNum, Integer pageSize){
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        pageThreadLocal.set(page);
    }

    /**
     * 获取分页信息
     */

    public static Page getPage(){
        return pageThreadLocal.get();
    }

    /**
     * 清除信息
     */
    public static void clear(){
        pageThreadLocal.remove();
    }



}
