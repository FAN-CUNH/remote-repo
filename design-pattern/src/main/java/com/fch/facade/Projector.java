package com.fch.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.facade
 * @ClassName Projector
 * @Description TODO 投影仪
 * @Author Fan-CUNH
 * @Date 2023/8/4 14:55
 * @Version 1.0
 */
@Slf4j
public class Projector {
    private static Projector projector = new Projector();

    public static Projector getInstance() {
        return projector;
    }

    /**
     * 打开Projector
     */
    public void on() {
        log.info("{}", " 投影仪已运行 ");
    }

    /**
     * 关闭Projector
     */
    public void off() {
        log.info("{}", " 投影仪机关闭 ");
    }
}
