package com.fch.decorator;

import com.fch.decorator.coffee.Drink;
import com.fch.decorator.coffee.LongBlack;

/**
 * @packageName com.fch.decorator
 * @ClassName CoffeeBar
 * @Description TODO 客户端 咖啡馆
 * @Author Fan-CUNH
 * @Date 2023/8/3 15:43
 * @Version 1.0
 */
public class CoffeeBar {
    public static void main(String[] args) {
        Drink order = new LongBlack();
        System.out.println("order = " + order);
    }
}
