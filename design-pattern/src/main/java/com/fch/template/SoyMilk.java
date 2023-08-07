package com.fch.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.template
 * @ClassName SoyMilk
 * @Description TODO 豆浆 抽象类
 * @Author Fan-CUNH
 * @Date 2023/8/5 20:56
 * @Version 1.0
 */
@Slf4j
public abstract class SoyMilk {
    /**
     * 模版方法 制作 用final修饰，不让子类去重写此方法
     */
    final void make() {
        select();
        if (isAdd()) {
            add();
        }
        soak();
        beat();
    }

    /**
     * 选材
     */
    void select() {
        log.info("第一步：选择好的新鲜黄豆");
    }

    /**
     * 添加配料 由于不同的豆浆需要不同的配料 所以做成抽象方法 由子类重写
     */
    abstract void add();

    /**
     * 浸泡黄豆
     */
    void soak() {
        log.info("第三步：黄豆和配料开始浸泡，需要三个小时");
    }

    /**
     * 击碎
     */
    void beat() {
        log.info("第四步：黄豆和配料放到豆浆机去打碎");
    }

    /**
     * @return 默认返回true 添加配料 可由子类覆写
     */
    boolean isAdd() {
        return true;
    }
}
