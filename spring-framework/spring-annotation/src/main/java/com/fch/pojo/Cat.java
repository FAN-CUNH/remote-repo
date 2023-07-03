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
@Primary
public class Cat extends Animal{
    @Override
    public void say() {
        System.out.println("I am Cat.");
    }
}
