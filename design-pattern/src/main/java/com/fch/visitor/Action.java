package com.fch.visitor;

/**
 * @packageName com.fch.visitor
 * @ClassName Action
 * @Description TODO 访问者
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:12
 * @Version 1.0
 */
public abstract class Action {
    /**
     * 得到男性的评价
     *
     * @param man 男
     */
    public abstract void getManResult(Man man);

    /**
     * 得到女性的评价
     *
     * @param woman 女
     */
    public abstract void getWomanResult(Woman woman);
}
