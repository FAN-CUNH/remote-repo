package javase.day18.unit_work.annotation_work;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 20:29
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Book {
    String value();
    double price() default 200;
    String[] authors();
}
