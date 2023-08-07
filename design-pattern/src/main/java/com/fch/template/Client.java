package com.fch.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.template
 * @ClassName TraditionClient
 * @Description TODO 客户端
 * @Author Fan-CUNH
 * @Date 2023/8/5 21:07
 * @Version 1.0
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        // 制作红豆豆浆
        log.info("----- 制作红豆豆浆 -----");
        RedBeanSoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();

        // 制作花生豆浆
        log.info("----- 制作花生豆浆 -----");
        PeanutSoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();

        // 制作纯豆浆
        log.info("----- 制作纯豆浆 ------");
        PureSoyMilk pureSoyMilk = new PureSoyMilk();
        pureSoyMilk.make();
    }
}
