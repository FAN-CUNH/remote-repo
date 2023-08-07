package com.fch.strategy.tradition;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.strategy
 * @ClassName Duck
 * @Description TODO 鸭子 抽象父类
 * @Author Fan-CUNH
 * @Date 2023/8/5 22:38
 * @Version 1.0
 */
@Slf4j
public abstract class Duck {
    public void quack() {
        log.info("鸭子会叫");
    }
    public void swim() {
        log.info("鸭子会游泳");
    }
    public void fly() {
        log.info("鸭子会飞");
    }

    /**
     * 显示鸭子信息
     */
    public abstract void info();
}
