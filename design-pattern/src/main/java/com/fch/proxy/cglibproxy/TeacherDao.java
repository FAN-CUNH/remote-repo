package com.fch.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.proxy.cglibproxy
 * @ClassName TeacherDao
 * @Description TODO Cglib代理 被代理对象
 * @Author Fan-CUNH
 * @Date 2023/8/5 18:29
 * @Version 1.0
 */
@Slf4j
public class TeacherDao {
    public void teach() {
        log.info("教师授课中... Cglib代理，不需要实现接口");
    }
}
