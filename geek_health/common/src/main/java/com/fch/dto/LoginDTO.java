package com.fch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @packageName com.fch.dto
 * @ClassName LoginDTO
 * @Description 登录DTO
 * @Author Fan-CUNH
 * @Date 2023/7/18 13:54
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO implements Serializable {
    private String telephone;
    private String validateCode;
}
