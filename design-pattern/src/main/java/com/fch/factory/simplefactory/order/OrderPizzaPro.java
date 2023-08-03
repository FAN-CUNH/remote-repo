package com.fch.factory.simplefactory.order;

import com.fch.factory.simplefactory.factory.PizzaSimpleFactory;
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
public class OrderPizzaPro {

    // 声明一个简单工厂
    PizzaSimpleFactory pizzaSimpleFactory;
    Pizza pizza;

    // 构造器
    public OrderPizzaPro(PizzaSimpleFactory pizzaSimpleFactory) {
        setFactory(pizzaSimpleFactory);
    }

    public void setFactory(PizzaSimpleFactory pizzaSimpleFactory) {
        this.pizzaSimpleFactory = pizzaSimpleFactory;

        do {
            String pizzaType = getPizzaType();

            // 工厂生成披萨
            pizza = pizzaSimpleFactory.createPizza(pizzaType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 披萨订购失败 ");
            }
        } while (true);

    }

    // 获取用户希望购买的披萨类型
    public String getPizzaType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请录入订购的披萨类型： ");
        return scanner.next();
    }
}
