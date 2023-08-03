package com.fch.abstractfactory.pizza;

/**
 * @packageName com.fch.factorymode.factorymethod.pizza
 * @ClassName BJCheesePizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 10:56
 * @Version 1.0
 */
public class BJCheesePizza extends Pizza {
    /**
     * 准备原材料抽象方法，不同的披萨不一样,因此做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println(" 给制作北京奶酪披萨准备原材料 ");
    }
}
