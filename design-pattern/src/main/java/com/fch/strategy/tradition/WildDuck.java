package com.fch.strategy.tradition;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.strategy
 * @ClassName WildDuck
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 22:42
 * @Version 1.0
 */
@Slf4j
public class WildDuck extends Duck {
    /**
     * 显示鸭子信息
     */
    @Override
    public void info() {
        log.info("野鸭");
    }
}
