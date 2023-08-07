package com.fch.strategy.tradition;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.strategy
 * @ClassName PekingDuck
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 22:42
 * @Version 1.0
 */
@Slf4j
public class PekingDuck extends Duck {
    /**
     * 显示鸭子信息
     */
    @Override
    public void info() {
        log.info("北京鸭");
    }

    /**
     * 覆写父类的飞行方法 由具体的子类决定
     */
    @Override
    public void fly() {
        log.info("北京鸭不会飞");
    }
}
