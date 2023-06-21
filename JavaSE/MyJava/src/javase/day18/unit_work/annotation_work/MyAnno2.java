package javase.day18.unit_work.annotation_work;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAnno2
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 19:20
 * @Version 1.0
 */
@Target(ElementType.FIELD) // 修饰属性
@Retention(RetentionPolicy.SOURCE) // 只在源码阶段生效
public @interface MyAnno2 {
    String type() default "java";
}
