package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.domain
 * @ClassName Book
 * @Description 书本模型类
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:48
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookType;
    private String description;
}
