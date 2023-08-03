package com.fch.factory.simplefactory.store;

import com.fch.factory.simplefactory.order.OrderPizzaPro;
import com.fch.factory.simplefactory.factory.PizzaSimpleFactory;

/**
 * @packageName com.fch.simpleFactory.store
 * @ClassName PizzaStore
 * @Description TODO 披萨店
 * @Author Fan-CUNH
 * @Date 2023/8/2 9:39
 * @Version 1.0
 */
public class PizzaStorePro {
    public static void main(String[] args) {
        new OrderPizzaPro(new PizzaSimpleFactory());
    }
}
