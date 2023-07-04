package com.fch.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @packageName com.fch.pojo
 * @ClassName Cat
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 14:54
 * @Version 1.0
 */


@EqualsAndHashCode(callSuper = true)
@Data
@Component
@Primary // 表示自动注入时，优先注入此对象
public class Cat extends Animal{
    /**
     * 重写父类的方法
     */
    @Override
    public void say() {
        System.out.println("I am Cat.");
    }

    /**
     * 自己的私有方法
     */
    public void eat() {
        System.out.println("eat");
    }
}
