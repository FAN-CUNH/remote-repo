package com.fch.proxy.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @packageName com.fch.proxy.dynamicproxy
 * @ClassName ProxyFactory
 * @Description TODO 代理工厂 生成代理对象
 * @Author Fan-CUNH
 * @Date 2023/8/5 17:22
 * @Version 1.0
 */
@Slf4j
public class ProxyFactory {
    /**
     * 被代理对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * newProxyInstance()的三个参数 ClassLoader loader,Class<?>[] interfaces,InvocationHandler h
     * 1. ClassLoader loader ： 指定当前被代理对象使用的类加载器，获取加载器的方法固定
     * 2. Class<?>[] interfaces ： 被代理对象实现的接口类型，使用泛型方法确认类型
     * 3. InvocationHandler h ： 事件处理，执行目标对象的方法时，会触发事件处理器方法，会把当前执行的被代理对象方法作为=参数传入
     *
     * @return 代理对象
     */
    public Object getProxyTarget() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * @param proxy  the proxy instance that the method was invoked on
             * @param method the {@code Method} instance corresponding to
             *               the interface method invoked on the proxy instance.  The declaring
             *               class of the {@code Method} object will be the interface that
             *               the method was declared in, which may be a superinterface of the
             *               proxy interface that the proxy class inherits the method through.
             * @param args   an array of objects containing the values of the
             *               arguments passed in the method invocation on the proxy instance,
             *               or {@code null} if interface method takes no arguments.
             *               Arguments of primitive types are wrapped in instances of the
             *               appropriate primitive wrapper class, such as
             *               {@code java.lang.Integer} or {@code java.lang.Boolean}.
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("JDK代理开始...");
                return  method.invoke(target, args);
            }
        });
    }
}
