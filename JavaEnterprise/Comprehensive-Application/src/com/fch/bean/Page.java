package com.fch.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.bean
 * @ClassName Page
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/5 13:21
 * @Version 1.0
 */
public class Page<T> {
    private List<T> data = new ArrayList<>(16);
    private int currentPage = 1;
    private int pageSize;
    private int everyPageRow = 3;


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getEveryPageRow() {
        return everyPageRow;
    }

    public void setEveryPageRow(int everyPageRow) {
        this.everyPageRow = everyPageRow;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
