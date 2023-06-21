package javase.day18.unit_work.annotation_work;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAnno3
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 19:25
 * @Version 1.0
 */
@Target(ElementType.METHOD) // 只能修饰方法
@Retention(RetentionPolicy.CLASS) // 只能生效在字节码和源码阶段
public @interface MyAnno3 {
    String type();
    int[] intArr();
}
