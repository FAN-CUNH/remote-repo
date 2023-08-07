package com.fch.strategy;

import com.fch.strategy.behavior.fly.GoodFly;
import com.fch.strategy.strategy.ToyDuck;

/**
 * @packageName com.fch.strategy
 * @ClassName StrategyClient
 * @Description TODO 策略模式模拟客户端
 * @Author Fan-CUNH
 * @Date 2023/8/5 23:27
 * @Version 1.0
 */
public class StrategyClient {
    public static void main(String[] args) {
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        toyDuck.setFlyBehavior(new GoodFly());
        toyDuck.fly();
    }
}
