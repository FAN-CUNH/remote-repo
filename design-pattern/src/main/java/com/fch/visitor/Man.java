package com.fch.visitor;

/**
 * @packageName com.fch.visitor
 * @ClassName Man
 * @Description TODO 具体的元素
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:12
 * @Version 1.0
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
