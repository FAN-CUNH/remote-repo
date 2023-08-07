package com.fch.proxy;


import com.fch.proxy.cglibproxy.ProxyFactory;
import com.fch.proxy.cglibproxy.TeacherDao;

/**
 * @packageName com.fch.proxy
 * @ClassName CglibClient
 * @Description TODO Cglib客户端
 * @Author Fan-CUNH
 * @Date 2023/8/5 18:39
 * @Version 1.0
 */
public class CglibClient {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao teacherDao = new TeacherDao();

        // 传入目标对象，获取代理对象
        TeacherDao proxyTeacherDao = (TeacherDao) new ProxyFactory(teacherDao).getProxyTarget();

        // 执行代理对象的方法,触发intercept方法，从而事项对目标对象的调用
        proxyTeacherDao.teach();
    }
}
