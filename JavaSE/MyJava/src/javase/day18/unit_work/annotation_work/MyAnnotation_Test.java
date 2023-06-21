package javase.day18.unit_work.annotation_work;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName MyAnnotation_Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 19:19
 * @Version 1.0
 */
@MyAnno1
public class MyAnnotation_Test {
    @MyAnno2
    String name;
    @MyAnno3(type = "java", intArr = {1, 2, 3})
    @MyTest
    public void println() {
        System.out.println("用注解修饰的方法！");
    }
    public void println2() {
        System.out.println("没用注解修饰的方法！");
    }
    public static void main(String[] args) throws Exception{
        MyAnnotation_Test myAnnotation_test = new MyAnnotation_Test();
        myAnnotation_test.name = "zhangsan";
        System.out.println(myAnnotation_test.name);
        myAnnotation_test.println();
        myAnnotation_test.println2();
        Method[] methods = MyAnnotation_Test.class.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));
        for (Method everyMethod: methods
             ) {
            if (everyMethod.isAnnotationPresent(MyTest.class)) {
               Class c = MyAnnotation_Test.class;
               Object o = c.newInstance();
               everyMethod.invoke(o, null);
            }
        }
        Arrays.stream(methods).forEach(method -> {
            if (method.isAnnotationPresent(MyTest.class)){
                try {
                    method.invoke(MyAnnotation_Test.class.newInstance(), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
