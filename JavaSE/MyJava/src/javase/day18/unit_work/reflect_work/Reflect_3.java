package javase.day18.unit_work.reflect_work;

/**
 * @ClassName Reflect_3
 * @Description 1. 定义一个类，在类中定义一个成员方法show，方法功能是：打印一个字符串。
 *              2. 使用反射机制创建该类的对象，并调用该对象的show方法。
 * @Author Cunhao Fan
 * @Date 2023/5/3 16:09
 * @Version 1.0
 */
public class Reflect_3 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("javase.day18.unit_work.reflect_work.Student");
        Object o = c.newInstance();
        c.getMethod("show", String.class).invoke(o, "反射案例3");
    }

}
