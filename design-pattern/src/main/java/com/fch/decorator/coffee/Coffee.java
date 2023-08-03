package com.fch.decorator.coffee;

/**
 * @packageName com.fch.decorator.coffee
 * @ClassName Coffee
 * @Description TODO 咖啡类 抽取出咖啡大类的共同特点 作为中间层 由具体咖啡继承
 * @Author Fan-CUNH
 * @Date 2023/8/3 14:38
 * @Version 1.0
 */
public class Coffee extends Drink {
    /**
     * 计算饮料的小计
     *
     * @return 小计
     */
    @Override
    public float cost() {
        return getPrice();
    }
}
