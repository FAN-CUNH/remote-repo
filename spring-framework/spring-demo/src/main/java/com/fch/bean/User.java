package com.fch.bean;

import lombok.Data;

/**
 * @packageName com.fch.bean
 * @ClassName User
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/29 9:53
 * @Version 1.0
 */
@Data
public class User {
    private String id;
    private String name;

    public User() {
        System.out.println("User is init...");
    }
}
