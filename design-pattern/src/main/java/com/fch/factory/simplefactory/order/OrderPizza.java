package com.fch.factory.simplefactory.order;

import com.fch.factory.simplefactory.pizza.CheesePizza;
import com.fch.factory.simplefactory.pizza.GreekPizza;
import com.fch.factory.simplefactory.pizza.Pizza;

import java.util.Scanner;

/**
 * @packageName com.fch.simpleFactory.order
 * @ClassName OrderPizza
 * @Description TODO 订购披萨
 * @Author Fan-CUNH
 * @Date 2023/8/2 9:25
 * @Version 1.0
 */
public class OrderPizza {

    // 构造器
    public OrderPizza() {
        Pizza pizza;

        // 生成披萨
        do {
            // 订购披萨的类型
            String pizzaType = getPizzaType();

            if ("greek".equals(pizzaType)) {
                pizza = new GreekPizza();
                pizza.setName(" 希腊披萨 ");
            } else if ("cheese".equals(pizzaType)) {
                pizza = new CheesePizza();
                pizza.setName(" 奶酪披萨 ");
            } else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    // 获取用户希望购买的披萨类型
    public String getPizzaType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请录入订购的披萨类型： ");
        return scanner.next();
    }
}
