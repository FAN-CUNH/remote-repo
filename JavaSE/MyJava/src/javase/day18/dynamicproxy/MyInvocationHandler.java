package javase.day18.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Description 编写代理模板 实现接口InvovationHandler，重写invoke方法
 * @Author Cunhao Fan
 * @Date 2023/4/27 19:58
 * @Version 1.0
 */
/*这是调用处理器接口，它自定义了一个invoke方法，用于集中处理在动态代理类对象上的方法调用，通常在该方法中实现对委托类方法的处理以及访问.*/
public class MyInvocationHandler implements InvocationHandler {
    /*声明被代理对象*/
    Object calculator;
    /*有参构造为目标对象进行赋值*/
    public MyInvocationHandler(Object calculator) {
        this.calculator = calculator;
    }
    /*
    *Object proxy生成的代理对象。
    *Method method：被代理对象的方法。
    *Object[] args：被代理方法中的参数。这里因为参数个数不定，所以用一个对象数组来表示。
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // 重写invoke方法
        /*实例化日志信息模板类对象*/
        DailyRecordMess dailyRecordMess = new DailyRecordMess();
        dailyRecordMess.Before(args, method.getName()); // 调用前置日志
        Object result = method.invoke(calculator, args); // 调用核心方法
        dailyRecordMess.After(method.getName(), (int)result); // 调用后置日志
        return result;
    }
}
