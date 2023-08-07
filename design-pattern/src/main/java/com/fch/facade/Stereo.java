package com.fch.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.facade
 * @ClassName Stereo
 * @Description TODO 立体声
 * @Author Fan-CUNH
 * @Date 2023/8/4 15:00
 * @Version 1.0
 */
@Slf4j
public class Stereo {
    private static Stereo stereo = new Stereo();

    public static Stereo getInstance() {
        return stereo;
    }

    /**
     * 开启立体声
     */
    public void on() {
        log.info("{}", " 立体声已开启 ");
    }

    /**
     * 关闭立体声
     */
    public void off() {
        log.info("{}", " 立体声已关闭 ");
    }

    /**
     * 调大立体声
     */
    public void up() {
        log.info("{}", " 立体声已调大 ");
    }

    /**
     * 调小立体声
     */
    public void down() {
        log.info("{}", " 立体声已调小 ");
    }
}
