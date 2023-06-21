package javase.day18.unit_work.annotation_work;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAnno1
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 19:11
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS) //源码和字节码阶段
public @interface MyAnno1 {
}

