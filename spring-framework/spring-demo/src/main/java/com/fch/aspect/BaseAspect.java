package com.fch.aspect;

/**
 * @packageName com.fch.aspect
 * @ClassName BaseAspect
 * @Description 自定义切面，实现业务功能增强
 * @Author Fan-CUNH
 * @Date 2023/6/30 16:24
 * @Version 1.0
 */
public class BaseAspect {

    /**
     * 前置通知
     */
    public void before() {
        System.out.println("method is running...");
    }

    /**
     * 后置通知
     */
    public void after() {
        System.out.println("method is stop...");
    }
}
