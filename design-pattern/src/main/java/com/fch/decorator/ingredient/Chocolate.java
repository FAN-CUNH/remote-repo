package com.fch.decorator.ingredient;

import com.fch.decorator.coffee.Drink;

/**
 * @packageName com.fch.decorator.ingredient
 * @ClassName Chocolate
 * @Description TODO 具体的装饰者
 * @Author Fan-CUNH
 * @Date 2023/8/3 15:40
 * @Version 1.0
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f);
    }
}
