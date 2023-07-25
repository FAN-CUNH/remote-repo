package com.fch.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @packageName com.fch.domain
 * @ClassName Person
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 15:49
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    // 将字符串类型转换成Date类型
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    // 将对象中的Date类型转化成JSON字符串
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Pet pet;
}
