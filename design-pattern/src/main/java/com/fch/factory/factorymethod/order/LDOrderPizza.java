package com.fch.factory.factorymethod.order;

import com.fch.factory.factorymethod.pizza.*;

/**
 * @packageName com.fch.factorymode.factorymethod.order
 * @ClassName LDOrderPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:09
 * @Version 1.0
 */
public class LDOrderPizza extends OrderPizza{
    /**
     * 根据披萨种类正常披萨
     *
     * @param pizzaType 披萨种类
     * @return 披萨
     */
    @Override
    Pizza createPizza(String pizzaType) {
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
