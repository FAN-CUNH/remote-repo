package javase.day25.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName javase.day25.entity
 * @ClassName Page
 * @Description 对账户信息进行分页
 * @Author CunHao Fan
 * @Date 2023/5/23 10:15
 * @Version 1.0
 */
public class Page<T> {
    /**
     * 对账户信息进行分页的集合
     */
    List<T> mapList = new ArrayList<T>(16);
    /**
     * 页码默认第一页
     */
    int currentPage = 1;
    /**
     * 每页展示条数为5条
     */
    int everyPageSize = 5;
    /**
     * 总页数
     */
    int allPageCount;

    /**
     * set get方法给成员变量进行赋值和修改
     */
    public List<T> getMapList() {
        return mapList;
    }

    public void setMapList(List<T> mapList) {
        this.mapList = mapList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getEveryPageSize() {
        return everyPageSize;
    }

    public void setEveryPageSize(int everyPageSize) {
        this.everyPageSize = everyPageSize;
    }

    public int getAllPageCount() {
        return allPageCount;
    }

    public void setAllPageCount(int allPageCount) {
        this.allPageCount = allPageCount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "mapList=" + mapList +
                ", currentPage=" + currentPage +
                ", everyPageSize=" + everyPageSize +
                ", allPageCount=" + allPageCount +
                '}';
    }
}
