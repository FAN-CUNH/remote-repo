package javase.day18.unit_work.reflect_work;

import java.lang.reflect.Field;

/**
 * @ClassName Reflect_5
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 17:03
 * @Version 1.0
 */
public class Reflect_5 {
    public void setProperty(Object obj, String propertyName, Object value) throws Exception{
        Class c = obj.getClass();
        Field field = c.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    public void getProperty(Object obj, String propertyName) throws Exception {
        Class c = obj.getClass();
        Field field = c.getDeclaredField(propertyName);
        field.setAccessible(true);
        System.out.println(field.get(obj));
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("zhangsan");
        Reflect_5 reflect_5 = new Reflect_5();
        reflect_5.setProperty(student, "name", "lisi");
        reflect_5.getProperty(student, "name");
    }
}
