package com.fch.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @packageName com.fch.proxy.cglibproxy
 * @ClassName ProxyFactory
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 18:31
 * @Version 1.0
 */
@Slf4j
public class ProxyFactory implements MethodInterceptor {

    // 聚合被代理对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("Cglib代理开始");
        Object invoke = method.invoke(target, objects);
        log.info("Cglib代理介绍");
        return invoke;
    }

    /**
     * @return 返回代理对象
     */
    public Object getProxyTarget() {
        // 1.创建一个工具类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调函数
        enhancer.setCallback(this);
        // 4.创建子类对象，即代理对象
        return enhancer.create();
    }
}
