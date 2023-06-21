package javase.day18.bookstoreofannotation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName BookStoreDemo
 * @Description /*1. 定义注解Book，要求如下：
 *               - 包含属性：String value()   书名
 *               - 包含属性：double price()  价格，默认值为 100
 *               - 包含属性：String[] authors() 多位作者
 *               - 限制注解使用的位置：类和成员方法上
 *               - 指定注解的有效范围：RUNTIME
 *               定义BookStore类，在类和成员方法上使用Book注解
 *               定义TestAnnotation测试类获取Book注解上的数据
 * @Author Cunhao Fan
 * @Date 2023/4/27 14:43
 * @Version 1.0
 */
public class BookStoreDemo {
    public static void main(String[] args) throws Exception{
        /*获取被注解修饰的Class对象*/
        Class c = BookStore.class; // 根据类获取Class对象
        /*获取Class对象的所有方法*/
        Method[] allMethod = c.getDeclaredMethods();
        /*判断方法上方是否使用Book注解*/
        for (Method everyMethod: allMethod
             ) {
            if (everyMethod.isAnnotationPresent(Book.class)) {
                Book b = everyMethod.getAnnotation(Book.class);
                System.out.println("注解类的属性："+b.value()+"价格："+b.price()+"作者："+ Arrays.toString(b.authors()));
            }
        }

    }
}
