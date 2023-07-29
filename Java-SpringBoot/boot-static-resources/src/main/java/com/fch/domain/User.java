package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.domain
 * @ClassName User
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 20:08
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
