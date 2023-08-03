package com.fch.prototype.traditional.sheep;

/**
 * @packageName com.fch.prototype.traditional
 * @ClassName Sheep
 * @Description TODO 实体类 羊
 * @Author Fan-CUNH
 * @Date 2023/8/2 15:43
 * @Version 1.0
 */
public class Sheep {
    private String name;
    private String color;
    private Integer age;

    public Sheep() {
    }

    public Sheep(String name, String color, Integer age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Sheep{name = " + name + ", color = " + color + ", age = " + age + "}";
    }
}
