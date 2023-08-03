package com.fch.factory.simplefactory.factory;

import com.fch.factory.simplefactory.pizza.CheesePizza;
import com.fch.factory.simplefactory.pizza.ChinaPizza;
import com.fch.factory.simplefactory.pizza.GreekPizza;
import com.fch.factory.simplefactory.pizza.Pizza;

/**
 * @packageName com.fch.simpleFactory.factory
 * @ClassName PizzaSimpleFactory
 * @Description 生产披萨的简单工厂 只负责生成披萨
 * @Author Fan-CUNH
 * @Date 2023/8/2 10:02
 * @Version 1.0
 */
public class PizzaSimpleFactory {
    public Pizza createPizza(String pizzaType) {
        System.out.println(" pizza 简单工厂 ");

        Pizza pizza = null;

        if ("greek".equals(pizzaType)) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if ("cheese".equals(pizzaType)) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if ("china".equals(pizzaType)) {
            pizza = new ChinaPizza();
            pizza.setName(" 中国披萨 ");
        }

        return pizza;
    }
}
