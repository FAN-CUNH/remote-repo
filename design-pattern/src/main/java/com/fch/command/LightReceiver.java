package com.fch.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.command
 * @ClassName LightReceiver
 * @Description TODO 命令接收者（命令的具体执行者）
 * @Author Fan-CUNH
 * @Date 2023/8/7 10:00
 * @Version 1.0
 */
@Slf4j
public class LightReceiver {
    /**
     * 打开电灯
     */
    public void on() {
        log.info("打开电灯");
    }

    /**
     * 关闭电灯
     */
    public void off() {
        log.info("关闭电灯");
    }
}
