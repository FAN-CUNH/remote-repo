package com.fch.strategy.tradition;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.strategy
 * @ClassName ToyDuck
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 22:44
 * @Version 1.0
 */
@Slf4j
public class ToyDuck extends Duck {
    /**
     * 显示鸭子信息
     */
    @Override
    public void info() {
        log.info("玩具鸭");
    }

    // 由于是玩具鸭 所以要重写父类的所有方法
    @Override
    public void quack() {
        log.info("玩具鸭不会叫");
    }

    @Override
    public void swim() {
        log.info("玩具鸭不会游泳");
    }

    @Override
    public void fly() {
        log.info("玩具鸭不会飞");
    }
}
