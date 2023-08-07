package com.fch.proxy.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.proxy.dynamicproxy
 * @ClassName TeacherDao
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 17:21
 * @Version 1.0
 */
@Slf4j
public class TeacherDao implements ITeacherDao {
    /**
     * 授课方法
     */
    @Override
    public void teach() {
        log.info("教师正在授课...");
    }
}
