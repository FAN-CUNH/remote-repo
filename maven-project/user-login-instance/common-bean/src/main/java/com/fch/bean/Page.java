package com.fch.bean;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.bean
 * @ClassName Page
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/11 16:39
 * @Version 1.0
 */
public class Page<T> {
    /**
     * 当前页码
     */
    private int currentPage = 1;
    /**
     * 每页显示条数
     */
    private int pageSize = 3;
    /**
     * 总记录数
     */
    private int total;
    /**
     * 页面数据
     */
    private List<T> data;


    public Page() {
    }

    public Page(int currentPage, int pageSize, int total, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }


    /**
     * 获取
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置
     * @param currentPage 当前页码
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize 每页显示条数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return total
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total int -> 总记录数
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 获取
     * @return data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 设置
     * @param data List<T> -> 每页显示的数据
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{currentPage = " + currentPage + ", pageSize = " + pageSize + ", total = " + total + ", data = " + data + "}";
    }

}
