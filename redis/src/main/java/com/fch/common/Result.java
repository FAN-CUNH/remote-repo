package com.fch.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.common
 * @ClassName Result
 * @Description 统一响应数据
 * @Author Fan-CUNH
 * @Date 2023/7/22 21:23
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
}
