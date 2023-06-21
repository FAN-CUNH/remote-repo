package javase.day18.unit_work.junit_work;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName Calculator
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 14:55
 * @Version 1.0
 */
public class Calculator {
    Calculator calculator = null;
    @Before
    public void befer() {
        calculator = new Calculator();
        System.out.println("运行前："+calculator);
    }
    @Test
    public void add() {
        int a = 1;
        int b = 2;
        int result = a + b;
        System.out.println("a+b="+result);
    }
    @After
    public void after() {
        calculator = null;
        System.out.println("运行结束后："+calculator);
    }
}
