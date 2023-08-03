package com.fch.abstractfactory.factory;

import com.fch.factory.factorymethod.pizza.Pizza;

/**
 * @packageName com.fch.abstractfactory.order
 * @ClassName AbsFactory
 * @Description TODO Pizza抽象工厂
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:34
 * @Version 1.0
 */
public interface AbsFactory {
    // 生成Pizza
    Pizza createPizza(String pizzaType);
}
