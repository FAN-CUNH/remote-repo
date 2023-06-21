package javase.day18.unit_work.reflect_work;

import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * @ClassName Reflect_4
 * @Description 1. 编写一个类A，定义一个实例方法	，用于打印一个字符串。
 *              2. 在编写一个类TestA，用键盘输入一个字符串，该字符串就是类A的全名，使用反射机制创建该类的对象，并调用该对象中的方法showString
 * @Author Cunhao Fan
 * @Date 2023/5/3 16:24
 * @Version 1.0
 */
public class Reflect_4 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = scanner.next();
        Class c = Class.forName("javase.day18.unit_work.reflect_work.Student");
        Constructor constructor = c.getConstructor();
        Student student = (Student) constructor.newInstance();
        student.show(s);
    }
}
