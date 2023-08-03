package com.fch.factory.factorymethod.order;

import com.fch.factory.factorymethod.pizza.BJCheesePizza;
import com.fch.factory.factorymethod.pizza.BJPepperPizza;
import com.fch.factory.factorymethod.pizza.Pizza;

/**
 * @packageName com.fch.factorymode.factorymethod.order
 * @ClassName BJOrderPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:06
 * @Version 1.0
 */
public class BJOrderPizza extends OrderPizza{
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
            pizza = new BJCheesePizza();
            pizza.setName(" 北京奶酪披萨 ");
        } else if ("pepper".equals(pizzaType)) {
            pizza = new BJPepperPizza();
            pizza.setName(" 北京胡椒披萨 ");
        }
        return pizza;
    }
}
