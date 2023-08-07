package com.fch.strategy;

import com.fch.strategy.tradition.ToyDuck;
import com.fch.strategy.tradition.WildDuck;

/**
 * @packageName com.fch.strategy
 * @ClassName TraditionClient
 * @Description TODO 客模拟户端
 * @Author Fan-CUNH
 * @Date 2023/8/5 22:34
 * @Version 1.0
 */
public class TraditionClient {
    public static void main(String[] args) {
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.quack();
        toyDuck.swim();
        toyDuck.fly();
        toyDuck.info();

        WildDuck wildDuck = new WildDuck();
        wildDuck.info();
    }
}
