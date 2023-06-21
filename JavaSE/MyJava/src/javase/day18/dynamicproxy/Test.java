package javase.day18.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName Test
 * @Description 设置一个类Calculator，包含4个方法：加、减、乘、除，在4个方法上添加日志处理：在程序执行期间追踪正在发生的活动。要求使用动态代理实现日志追踪的效果。
 * @Author Cunhao Fan
 * @Date 2023/4/27 19:43
 * @Version 1.0
 */
/*获得底层生成的代理子类，需要目标类和代理模板*/
public class Test {
    public static void main(String[] args) {
        /*获取代理模板*/
        CalculatorParent calculatorParent = new Calculator();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(calculatorParent);
        /*被代理类通过反射获取类加载器*/
        ClassLoader classLoader = calculatorParent.getClass().getClassLoader();
        /*通过反射获取被代理类所有父类接口，以便于生成的代理类可以具有代理类接口中的所有方法。 */
        Class[] interfaceClass = calculatorParent.getClass().getInterfaces();

        calculatorParent = (CalculatorParent) Proxy.newProxyInstance(classLoader, interfaceClass, myInvocationHandler);

        calculatorParent.add(1, 2);
        calculatorParent.subtract(1, 2);
        calculatorParent.multiply(1, 2);
        calculatorParent.division(2, 1);
    }
}
