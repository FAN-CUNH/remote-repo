package com.fch.factory.simplefactory.pizza;

/**
 * @packageName com.fch.simpleFactory.pizza
 * @ClassName GreekPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 9:24
 * @Version 1.0
 */
public class GreekPizza extends Pizza{
    /**
     * 准备原材料抽象方法，不同的披萨不一样,因此做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println(" 给制作希腊披萨准备原材料 ");
    }
}
