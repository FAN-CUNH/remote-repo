package com.fch.abstractfactory.factory;

import com.fch.factory.factorymethod.pizza.BJCheesePizza;
import com.fch.factory.factorymethod.pizza.BJPepperPizza;
import com.fch.factory.factorymethod.pizza.Pizza;

/**
 * @packageName com.fch.abstract factory.order
 * @ClassName BJFactory
 * @Description TODO 北京子工厂
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:36
 * @Version 1.0
 */
public class BJFactory implements AbsFactory{
    /**
     * 根据披萨种类正常披萨
     *
     * @param pizzaType 披萨种类
     * @return 披萨
     */
    @Override
    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;

        if ("cheese".equals(pizzaType)) {
            pizza = new BJCheesePizza();
            pizza.setName(" 北京奶酪披萨 ");
        } else if ("pepper".equals(pizzaType)) {
            pizza = new BJPepperPizza();
            pizza.setName(" 北京胡椒披萨 ");
        }
        return pizza;
    }
}
