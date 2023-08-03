package com.fch.factory.factorymethod.pizza;

/**
 * @packageName com.fch.simpleFactory.pizza
 * @ClassName Pizza
 * @Description 披萨的抽象类
 * @Author Fan-CUNH
 * @Date 2023/8/1 16:50
 * @Version 1.0
 */
public abstract class Pizza {
    /**
     * 披萨名字
     */
    private String name;

    public Pizza() {
    }

    public Pizza(String name) {
        this.name = name;
    }

    /**
     * 准备原材料抽象方法，不同的披萨不一样,因此做成抽象方法
     */
    public abstract void prepare();

    /**
     * 烘烤方法
     */
    public void bake() {
        System.out.println(name + " baking ");
    }

    /**
     * 切割方法
     */
    public void cut() {
        System.out.println(name + " cutting ");
    }

    /**
     * 打包方法
     */
    public void box() {
        System.out.println(name + " boxing ");
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
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{name = " + name + "}";
    }
}
