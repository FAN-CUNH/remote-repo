package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.domain
 * @ClassName Pet
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 16:33
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String name;
    private Integer age;
}
