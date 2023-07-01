package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @packageName com.fch.bean
 * @ClassName Name
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/30 9:43
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    private String firstName;
    private String lastName;
}
