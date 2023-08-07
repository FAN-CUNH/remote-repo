package com.fch.visitor;

/**
 * @packageName com.fch.visitor
 * @ClassName Person
 * @Description TODO 元素
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:11
 * @Version 1.0
 */
public abstract class Person {
    /**
     * @param action 提供一个方法，供访问者访问
     */
    public abstract void accept(Action action);
}
