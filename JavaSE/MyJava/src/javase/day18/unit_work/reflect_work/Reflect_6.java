package javase.day18.unit_work.reflect_work;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName Reflect_6
 * @Description 1. 定义一个Person类，包含属性name、age。
 *              2. 使用反射的方式创建一个实例、调用构造函数初始化name、age。使用反射方式调用setName方法对姓名进行设置，不使用setAge方法直接使用反射方式对age赋值。
 * @Author Cunhao Fan
 * @Date 2023/5/3 17:21
 * @Version 1.0
 */
public class Reflect_6 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("javase.day18.unit_work.reflect_work.Student");
        Constructor constructor = c.getDeclaredConstructor(String.class, int.class);
        Object o = constructor.newInstance("zhangsan", 23);
        System.out.println(o);
        Method setName = c.getDeclaredMethod("setName", String.class);
        setName.invoke(o, "lisi");
        Field f = c.getDeclaredField("age");
        f.setAccessible(true);
        f.set(o, 18);
        System.out.println(o);
    }
}
