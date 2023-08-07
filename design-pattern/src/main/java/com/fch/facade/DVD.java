package com.fch.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.facade
 * @ClassName DVD
 * @Description TODO DVD播放器
 * @Author Fan-CUNH
 * @Date 2023/8/4 14:44
 * @Version 1.0
 */
@Slf4j
public class DVD {
    // 使用单例模式（饿汉式）创建本类对象
    private static DVD instance = new DVD();

    /**
     * @return 单例本类对象
     */
    public static DVD getInstance() {
        return instance;
    }

    /**
     * 打开DVD
     */
    public void on() {
        log.info("{}", " DVD已打开 ");
    }

    /**
     * 关闭DVD
     */
    public void off() {
        log.info("{}", " DVD已关闭 ");
    }

    /**
     * 播放DVD
     */
    public void play() {
        log.info("{}", " DVD正在播放 ");
    }

    /**
     * 暂停DVD
     */
    public void pause() {
        log.info("{}", " DVD已暂停 ");
    }
}
