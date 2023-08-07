package com.fch.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.template
 * @ClassName PeanutSoyMilk
 * @Description TODO 花生豆浆
 * @Author Fan-CUNH
 * @Date 2023/8/5 21:06
 * @Version 1.0
 */
@Slf4j
public class PeanutSoyMilk extends SoyMilk {
    /**
     * 添加配料 由于不同的豆浆需要不同的配料 所以做成抽象方法 由子类重写
     */
    @Override
    void add() {
        log.info("第二步：加入花生");
    }
}
