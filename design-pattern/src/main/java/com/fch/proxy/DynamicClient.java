package com.fch.proxy;

import com.fch.proxy.dynamicproxy.ITeacherDao;
import com.fch.proxy.dynamicproxy.ProxyFactory;
import com.fch.proxy.dynamicproxy.TeacherDao;
import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.proxy
 * @ClassName DynamicClient
 * @Description TODO 动态代理客户端
 * @Author Fan-CUNH
 * @Date 2023/8/5 17:35
 * @Version 1.0
 */
@Slf4j
public class DynamicClient {
    public static void main(String[] args) {
        // 创建被代理对象
        TeacherDao teacherDao = new TeacherDao();

        // 创建代理对象
        ITeacherDao proxyTarget = (ITeacherDao) new ProxyFactory(teacherDao).getProxyTarget();

        proxyTarget.teach();
        log.info("教师的类型 ：{}", proxyTarget.getClass());
    }
}
