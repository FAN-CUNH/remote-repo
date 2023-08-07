package com.fch.template;

/**
 * @packageName com.fch.template
 * @ClassName PureSoyMilk
 * @Description TODO 纯豆浆
 * @Author Fan-CUNH
 * @Date 2023/8/5 21:48
 * @Version 1.0
 */
public class PureSoyMilk extends SoyMilk {
    /**
     * 添加配料 由于不同的豆浆需要不同的配料 所以做成抽象方法 由子类重写
     */
    @Override
    void add() {}

    /**
     * @return 默认返回true 添加配料 可由子类覆写
     */
    @Override
    boolean isAdd() {
        return false;
    }
}
