package com.fch.visitor;

/**
 * @packageName com.fch.visitor
 * @ClassName Woman
 * @Description TODO 具体的元素
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:11
 * @Version 1.0
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
