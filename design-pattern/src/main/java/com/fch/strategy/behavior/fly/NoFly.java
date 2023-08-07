package com.fch.strategy.behavior.fly;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.strategy.behavior
 * @ClassName NoFly
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 23:18
 * @Version 1.0
 */
@Slf4j
public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        log.info("不会飞");
    }
}
