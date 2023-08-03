package com.fch.builder.product;

/**
 * @packageName com.fch.builder.product
 * @ClassName House
 * @Description TODO 房子实体类
 * @Author Fan-CUNH
 * @Date 2023/8/2 19:26
 * @Version 1.0
 */
public class House {
    private String base;
    private String wall;
    private String roofed;

    public House() {
    }

    public House(String base, String wall, String roofed) {
        this.base = base;
        this.wall = wall;
        this.roofed = roofed;
    }

    /**
     * 获取
     * @return base
     */
    public String getBase() {
        return base;
    }

    /**
     * 设置
     * @param base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * 获取
     * @return wall
     */
    public String getWall() {
        return wall;
    }

    /**
     * 设置
     * @param wall
     */
    public void setWall(String wall) {
        this.wall = wall;
    }

    /**
     * 获取
     * @return roofed
     */
    public String getRoofed() {
        return roofed;
    }

    /**
     * 设置
     * @param roofed
     */
    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    public String toString() {
        return "House{base = " + base + ", wall = " + wall + ", roofed = " + roofed + "}";
    }
}
