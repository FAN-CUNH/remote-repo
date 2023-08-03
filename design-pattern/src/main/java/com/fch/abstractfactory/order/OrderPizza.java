package com.fch.abstractfactory.order;

import com.fch.abstractfactory.factory.AbsFactory;
import com.fch.factory.factorymethod.pizza.Pizza;

import java.util.Scanner;

/**
 * @packageName com.fch.abstractfactory.order
 * @ClassName OrderPizza
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:39
 * @Version 1.0
 */
public class OrderPizza {
    // 聚合工厂
    AbsFactory factory;

    // 构造器
    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }

    public void setFactory(AbsFactory factory) {
        Pizza pizza;
        this.factory = factory;

        do {
            System.out.println(" 请输入披萨种类 ");
            String pizzaType = new Scanner(System.in).next();

            // 生成pizza
            pizza = factory.createPizza(pizzaType);

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
