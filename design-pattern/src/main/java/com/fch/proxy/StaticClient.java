package com.fch.proxy;

import com.fch.proxy.staticproxy.TeacherDao;
import com.fch.proxy.staticproxy.TeacherDaoProxy;

/**
 * @packageName com.fch.proxy
 * @ClassName StaticClient
 * @Description TODO 静态代理客户端
 * @Author Fan-CUNH
 * @Date 2023/8/5 16:54
 * @Version 1.0
 */
public class StaticClient {
    public static void main(String[] args) {
        // 被代理对象
        TeacherDao teacherDao = new TeacherDao();

        // 代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        // 通过代理对象调用被代理对象
        teacherDaoProxy.teach();
    }
}
