package com.fch.decorator.ingredient;

import com.fch.decorator.coffee.Drink;

/**
 * @packageName com.fch.decorator.ingredient
 * @ClassName Milk
 * @Description TODO 具体的装饰者
 * @Author Fan-CUNH
 * @Date 2023/8/3 15:42
 * @Version 1.0
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }
}
