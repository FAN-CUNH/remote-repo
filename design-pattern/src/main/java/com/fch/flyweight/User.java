package com.fch.flyweight;

import lombok.Data;

/**
 * @packageName com.fch.flyweight
 * @ClassName User
 * @Description TODO 用户类 外部状态的体现
 * @Author Fan-CUNH
 * @Date 2023/8/5 15:11
 * @Version 1.0
 */
@Data
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}
