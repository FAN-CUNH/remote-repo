package com.fch.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @packageName com.fch.pojo
 * @ClassName User
 * @Description 简单JavaBean类
 * @Author CunHao Fan
 * @Date 2023/6/3 2:29
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "user")
public class User {
    private String name;
    private Integer age;
    private Address address;
}
