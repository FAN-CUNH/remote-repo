package com.fch.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.facade
 * @ClassName Screen
 * @Description TODO 屏幕实体类
 * @Author Fan-CUNH
 * @Date 2023/8/4 14:58
 * @Version 1.0
 */
@Slf4j
public class Screen {
    private static Screen screen = new Screen();

    public static Screen getInstance() {
        return screen;
    }

    /**
     * 升起屏幕
     */
    public void up() {
        log.info("{}", " 屏幕已收起 ");
    }

    /**
     * 下方屏幕
     */
    public void down() {
        log.info("{}", " 屏幕以下放 ");
    }
}
