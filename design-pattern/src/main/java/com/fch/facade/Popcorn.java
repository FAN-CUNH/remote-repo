package com.fch.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.facade
 * @ClassName Popcorn
 * @Description TODO 爆米花机
 * @Author Fan-CUNH
 * @Date 2023/8/4 14:51
 * @Version 1.0
 */
@Slf4j
public class Popcorn {
    private static Popcorn popcorn = new Popcorn();

    public static Popcorn getInstance() {
        return popcorn;
    }

    /**
     * 打开Popcorn
     */
    public void on() {
        log.info("{}", " 爆米花机已运行 ");
    }

    /**
     * 关闭Popcorn
     */
    public void off() {
        log.info("{}", " 爆米花机关闭 ");
    }

    /**
     * 出Pop
     */
    public void pop() {
        log.info("{}", " 爆爆米花 ");
    }
}
