package com.fch.abstractfactory.pizza;

/**
 * @packageName com.fch.factorymode.factorymethod.pizza
 * @ClassName BJPepperPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 10:57
 * @Version 1.0
 */
public class LDPepperPizza extends Pizza {
    /**
     * 准备原材料抽象方法，不同的披萨不一样,因此做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println(" 给制作伦敦胡椒披萨准备原材料 ");
    }
}
