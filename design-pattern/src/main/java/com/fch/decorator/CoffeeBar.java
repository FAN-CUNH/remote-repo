package com.fch.decorator;

import com.fch.decorator.coffee.Drink;
import com.fch.decorator.coffee.LongBlack;
import com.fch.decorator.ingredient.Chocolate;
import com.fch.decorator.ingredient.Milk;

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
        // 单品咖啡
        Drink order = new LongBlack();

        // 加份牛奶
        order = new Milk(order);

        // 加分巧克力
        order = new Chocolate(order);

        // 加分巧克力
        order = new Chocolate(order);

        System.out.println("描述 = " + order.getDes() + " 费用 = " + order.cost() );
    }
}
