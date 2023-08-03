package com.fch.decorator.coffee;

/**
 * @packageName com.fch.decorator.coffee
 * @ClassName EspressoCoffee
 * @Description TODO 具体咖啡 - 意大利咖啡 -> 被装饰者
 * @Author Fan-CUNH
 * @Date 2023/8/3 14:47
 * @Version 1.0
 */
public class EspressoCoffee extends Coffee {
    public EspressoCoffee() {
        setDes(" 意大利咖啡 ");
        setPrice(6.0f);
    }
}
