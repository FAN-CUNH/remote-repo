package javase.day17.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Reflect
 * @Description 反射：反射是一种机制，利用该机制可以在程序运行过程中对类进行解剖并操作类中的所有成员(成员变量，成员方法，构造方法)
 * @Author Cunhao Fan
 * @Date 2023/4/26 10:32
 * @Version 1.0
 */
public class Reflect {
    /*获取Class的三种方式*/
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*根据包名和类名获取Class对象*/
        Class c = Class.forName("javase.day17.test.Student");
        /*
        Class c = Student.class; 通过类名获取
        Class c = new Student().getClass(); 通过实例化对象获取
        */
        /*定义一个构造器集合用于接收所有的构造器*/
        Constructor[] allConstructor = c.getConstructors();
        /*声明一个构造器用于存储目标构造器*/
        Constructor constructor = null;
        /*遍历构造器数组*/
        for (Constructor everyContructor: allConstructor
             ) {
            /*获取每个构造器的参数类型存储到构造器参数类型数组*/
            Class[] everyContructorParameterTypes = everyContructor.getParameterTypes();
            if (everyContructorParameterTypes.length == 2) { // 参数个数为2的构造器
                if (everyContructorParameterTypes[0] == int.class && everyContructorParameterTypes[1] == double.class) { // 参数类型为int和double的
                    constructor = everyContructor;
                    break;
                }
            }
        }
        Object o = constructor.newInstance(18,177);
        System.out.println("实例化后的对象："+(Student)o);
        /*获取自己声明的所有属性*/
        Field[] allFields = c.getDeclaredFields();
        for (Field everyField: allFields
             ) {
            everyField.setAccessible(true); // 获取属性名
            System.out.println(everyField.getName()+"--"+everyField.get(o)); // 获取属性的值
        }
    }
}
