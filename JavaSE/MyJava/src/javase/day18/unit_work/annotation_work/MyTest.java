package javase.day18.unit_work.annotation_work;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 19:32
 * @Version 1.0
 */
@Target(ElementType.METHOD) // 只能修饰方法
@Retention(RetentionPolicy.RUNTIME) // 只在运行时生效
public @interface MyTest {
}
