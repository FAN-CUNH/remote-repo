package com.fch.pojo;

import lombok.Data;

/**
 * @packageName com.fch.pojo
 * @ClassName Animal
 * @Description 动物模版类
 * @Author Fan-CUNH
 * @Date 2023/7/3 14:49
 * @Version 1.0
 */

@Data
public abstract class Animal {
    public String name;
    public Integer age;
    public abstract void say();
}
