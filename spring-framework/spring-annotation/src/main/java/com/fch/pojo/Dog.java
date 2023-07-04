package com.fch.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * @packageName com.fch.pojo
 * @ClassName Dog
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 14:57
 * @Version 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class Dog extends Animal{
    /**
     * 重写父类的方法
     */
    @Override
    public void say() {
        System.out.println("I am Dog.");
    }
}
