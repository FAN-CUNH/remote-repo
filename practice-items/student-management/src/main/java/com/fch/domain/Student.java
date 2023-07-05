package com.fch.domain;

import lombok.Data;

/**
 * @packageName com.fch.domain
 * @ClassName Student
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/4 19:08
 * @Version 1.0
 */

@Data
public class Student {
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String address;
}
