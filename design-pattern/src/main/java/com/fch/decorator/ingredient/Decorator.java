package com.fch.decorator.ingredient;

import com.fch.decorator.coffee.Drink;

/**
 * @packageName com.fch.decorator.coffee
 * @ClassName Decorator
 * @Description TODO 装饰者
 * @Author Fan-CUNH
 * @Date 2023/8/3 15:30
 * @Version 1.0
 */
public class Decorator extends Drink {
    /**
     * 聚合的被装饰者
     */
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    /**
     * 计算饮料的小计
     *
     * @return 小计 自己的价格 + 被装饰的价格
     */
    @Override
    public float cost() {
        return super.getPrice() + obj.getPrice();
    }

    /**
     * 描述
     */
    @Override
    public String getDes() {
        return super.getDes() + " " + super.getPrice() + obj.getDes() + " " + obj.getPrice();
    }
}
