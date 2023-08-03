package com.fch.factory.factorymethod.order;

import com.fch.factory.factorymethod.pizza.Pizza;

import java.util.Scanner;

/**
 * @packageName com.fch.factorymode.factorymethod.order
 * @ClassName OrderPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 10:59
 * @Version 1.0
 */
public abstract class OrderPizza {
    // 定义一个抽象方法 createPizza 让各个工厂子类自己实现
    abstract Pizza createPizza(String pizzaType);

    // 构造器
    public OrderPizza() {
        Pizza pizza;

        do {
            System.out.println(" 输入披萨类型 ");
            String pizzaType = new Scanner(System.in).next();
            // 生成披萨交于各个工厂子类
            pizza = createPizza(pizzaType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购失败 ");
            }
        } while (true);
    }
}
