package com.fch.decorator.coffee;

import lombok.Data;

/**
 * @packageName com.fch.decorator.coffee
 * @ClassName Drink
 * @Description TODO 饮料抽象类
 * @Author Fan-CUNH
 * @Date 2023/8/3 14:38
 * @Version 1.0
 */
@Data
public abstract class Drink {
    /**
     * 描述
     */
    private String des;

    /**
     * 价格
     */
    private float price;

    /**
     * 计算饮料的小计 由子类来实现
     *
     * @return 小计
     */
    public abstract float cost();
}
