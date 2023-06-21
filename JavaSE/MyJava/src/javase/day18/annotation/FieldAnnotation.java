package javase.day18.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName FieldAnnotation
 * @Description 定义一个注解类，该类只能修饰属性，如果某个类中的属性用该注解修饰了那么就将其中的name值剔除所有的数字赋值给修饰的属性
 * @Author Cunhao Fan
 * @Date 2023/4/27 13:23
 * @Version 1.0
 */
@Target(ElementType.FIELD) // 表示该注解作用在成员变量
@Retention(RetentionPolicy.RUNTIME) // 表示该注解类作用在源码阶段，字节码文件阶段，运行阶段
public @interface FieldAnnotation {
    String name();
}
