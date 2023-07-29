package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.domain
 * @ClassName Blog
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/26 21:34
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String content;
}
