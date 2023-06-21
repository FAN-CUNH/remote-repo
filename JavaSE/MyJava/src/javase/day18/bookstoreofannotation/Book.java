package javase.day18.bookstoreofannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/27 14:39
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE}) // 注解只能用于类和成员方法
@Retention(RetentionPolicy.RUNTIME)
public @interface Book {
    String value();
    double price() default 100;
    String[] authors();
}

