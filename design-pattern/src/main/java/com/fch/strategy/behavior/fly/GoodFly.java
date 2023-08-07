package com.fch.strategy.behavior.fly;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.strategy.behavior
 * @ClassName GoodFly
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 23:17
 * @Version 1.0
 */
@Slf4j
public class GoodFly implements FlyBehavior {
    @Override
    public void fly() {
        log.info("飞的好");
    }
}
