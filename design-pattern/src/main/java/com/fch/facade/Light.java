package com.fch.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.facade
 * @ClassName Light
 * @Description TODO 灯光类
 * @Author Fan-CUNH
 * @Date 2023/8/4 15:04
 * @Version 1.0
 */
@Slf4j
public class Light {
    private static Light light = new Light();

    public static Light getInstance() {
        return light;
    }

    /**
     * 开启灯光
     */
    public void on() {
        log.info("{}", " 开启灯光 ");
    }

    /**
     * 关闭灯光
     */
    public void off() {
        log.info("{}", " 关闭灯光 ");
    }

    /**
     * 调亮
     */
    public void bright() {
        log.info("{}", " 灯光调亮 ");
    }

    /**
     * 调暗
     */
    public void dim() {
        log.info("{}", " 灯光调暗 ");
    }
}
