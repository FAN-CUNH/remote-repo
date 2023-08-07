package com.fch.visitor;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.visitor
 * @ClassName Success
 * @Description TODO 具体的访问者
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:16
 * @Version 1.0
 */
@Slf4j
public class Success extends Action {
    /**
     * 得到男性的评价
     *
     * @param man 男
     */
    @Override
    public void getManResult(Man man) {
        log.info("男性给的评价是成功");
    }

    /**
     * 得到女性的评价
     *
     * @param woman 女
     */
    @Override
    public void getWomanResult(Woman woman) {
        log.info("女性给的评价是成功");
    }
}
