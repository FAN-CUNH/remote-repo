package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.bean
 * @ClassName Blog
 * @Description 对应数据库中的blog表
 * @Author Fan-CUNH
 * @Date 2023/6/25 10:06
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private int id;
    private String title;
    private String content;
}
