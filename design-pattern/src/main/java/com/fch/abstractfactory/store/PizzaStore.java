package com.fch.abstractfactory.store;

import com.fch.abstractfactory.factory.BJFactory;
import com.fch.abstractfactory.order.OrderPizza;

/**
 * @packageName com.fch.abstractfactory.store
 * @ClassName PizzaStore
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:50
 * @Version 1.0
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
