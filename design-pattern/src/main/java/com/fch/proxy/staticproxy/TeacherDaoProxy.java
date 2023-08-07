package com.fch.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.proxy.staticproxy
 * @ClassName TeacherDaoProxy
 * @Description TODO 静态代理 代理对象
 * @Author Fan-CUNH
 * @Date 2023/8/5 16:48
 * @Version 1.0
 */
@Slf4j
public class TeacherDaoProxy implements ITeacherDao {

    /**
     * 被代理对象 通过接口来聚合
     */
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    /**
     * 授课方法
     */
    @Override
    public void teach() {
        // 此处是代理对象的方法执行前 可以对代理对象进行方法增强
        log.info("开始代理...");
        target.teach();
        // 此处是代理对象的方法执行后 可以对代理对象进行方法增强
        log.info("结束代理...");
    }
}
