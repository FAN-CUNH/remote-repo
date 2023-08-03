package com.fch.abstractfactory.factory;

import com.fch.factory.factorymethod.pizza.LDCheesePizza;
import com.fch.factory.factorymethod.pizza.LDPepperPizza;
import com.fch.factory.factorymethod.pizza.Pizza;

/**
 * @packageName com.fch.abstractfactory.order
 * @ClassName LDFactory
 * @Description TODO 伦敦子工厂
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:38
 * @Version 1.0
 */
public class LDFactory implements AbsFactory{

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
            pizza = new LDCheesePizza();
            pizza.setName(" 伦敦奶酪披萨 ");
        } else if ("pepper".equals(pizzaType)) {
            pizza = new LDPepperPizza();
            pizza.setName(" 伦敦胡椒披萨 ");
        }
        return pizza;
    }
}
