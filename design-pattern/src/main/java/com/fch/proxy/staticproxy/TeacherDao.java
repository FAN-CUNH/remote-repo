package com.fch.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.proxy.staticproxy
 * @ClassName TeacherDao
 * @Description TODO 被代理对象 教师
 * @Author Fan-CUNH
 * @Date 2023/8/5 16:46
 * @Version 1.0
 */
@Slf4j
public class TeacherDao implements ITeacherDao {
    /**
     * 授课方法
     */
    @Override
    public void teach() {
        log.info("教师授课中...");
    }
}
