package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.bean
 * @ClassName Course
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/26 16:32
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String couNo;
    private String couName;
}
