package com.fch.factory.simplefactory.pizza;

/**
 * @packageName com.fch.simpleFactory.pizza
 * @ClassName ChinaPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 10:21
 * @Version 1.0
 */
public class ChinaPizza extends Pizza {
    /**
     * 准备原材料抽象方法，不同的披萨不一样,因此做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println(" 给制作中国披萨准备原材料 ");
    }
}
