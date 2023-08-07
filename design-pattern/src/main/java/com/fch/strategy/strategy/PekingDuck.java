package com.fch.strategy.strategy;

import com.fch.strategy.behavior.fly.BadFly;
import com.fch.strategy.behavior.fly.NoFly;
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
    public PekingDuck() {
        flyBehavior = new BadFly();
    }

    /**
     * 显示鸭子信息
     */
    @Override
    public void info() {
        log.info("北京鸭");
    }

}
