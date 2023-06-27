package com.fch.bean;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @packageName com.fch.bean
 * @ClassName Student
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/26 16:30
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String stuNo;
    private String password;
    private String stuName;
    private Integer stuAge;
    private Date birthday;
    private List<Score> scores;
}
