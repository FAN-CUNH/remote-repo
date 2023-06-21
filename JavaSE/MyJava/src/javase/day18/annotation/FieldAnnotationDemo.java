package javase.day18.annotation;

import java.lang.reflect.Field;

/**
 * @ClassName FieldAnnotationDemo
 * @Description 定义一个注解类，该类只能修饰属性，如果某个类中的属性用该注解修饰了那么就将其中的name值剔除所有的数字赋值给修饰的属性
 * @Author Cunhao Fan
 * @Date 2023/4/27 13:36
 * @Version 1.0
 */
public class FieldAnnotationDemo {
    public static void main(String[] args) throws Exception{
        /*获取到属性注解的Class对象*/
        Class c = Student.class;
        Object o = c.newInstance();
        /*先根据Class对象获取所有的属性，在遍历所有的属性确定哪些是用注解修饰的属性*/
        Field[] allField = c.getDeclaredFields();
        System.out.println(allField.length);
        for (Field everyField: allField
             ) {
            System.out.println(everyField.getName());
            if (everyField.isAnnotationPresent(FieldAnnotation.class)) { // 过滤用FieldAnnotation注解修饰的属性
                /*获取到该注解name属性的值，并取出其中的所有数字*/
                //StringBuffer stringBuffer = new StringBuffer(everyField.getAnnotation(FieldAnnotation.class).name());
                //StringBuffer name = new StringBuffer("");
                //for (int i = 0; i < stringBuffer.length(); i++) {
                //    if (!(stringBuffer.charAt(i) >= '0' && stringBuffer.charAt(i) <= '9')) {
                //        name = name.append(stringBuffer.charAt(i));
                //    }
                //}
                String name = everyField.getAnnotation(FieldAnnotation.class).name();
                String name1 = "";
                for (int i = 0; i < name.length(); i++) {
                    if (!(name.charAt(i) >= '0' && name.charAt(i) <= '9')) {
                        name1 = name1+ name.charAt(i);
                    }
                }
                everyField.set(o, name1);
            }
        }
        System.out.println("被注解的属性赋值后："+((Student)o).name);
    }
}
