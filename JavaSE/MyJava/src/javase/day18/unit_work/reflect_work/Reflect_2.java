package javase.day18.unit_work.reflect_work;

import java.lang.reflect.Constructor;

/**
 * @ClassName Reflect_2
 * @Description 定义一个Student类，用反射去创建一个Student对象，使用两种方式
 *               1. 通过Class对象的方法创建。2. 通过Constructor对象的方法创建。
 * @Author Cunhao Fan
 * @Date 2023/5/3 15:37
 * @Version 1.0
 */
public class Reflect_2 {
    public static void main(String[] args) throws Exception{
        Class c1 = Student.class;
        Object o = c1.newInstance();
        Student student = (Student)o;
        student.setName("zs");
        System.out.println(student.getName() + ((Student)o).getName());
        Class c = Class.forName("javase.day18.unit_work.reflect_work.Student");
        Constructor constructor = c.getConstructor(String.class);
        System.out.println(constructor.getParameterCount());
        Object o1 = constructor.newInstance("zs");
        System.out.println(((Student)o1).getName());
    }
}
