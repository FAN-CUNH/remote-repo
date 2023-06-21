package javase.day17.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName Junit
 * @Description 单元测试：程序猿编写的一小段代码，用来对某个类中的某个方法进行功能测试或业务逻辑测试。
 * @Author Cunhao Fan
 * @Date 2023/4/26 10:04
 * @Version 1.0
 */
public class Junit {
    /*方法执行前或之后需要做某些事，可以用@Before和@After*/
    @Before
    public void before() {
        System.out.println("before");
    }
    @Test // 注解
    public void test() {
        System.out.println("Junit测试自己的方法");
    }
    @After
    public void after() {
        System.out.println("after");
    }
}
