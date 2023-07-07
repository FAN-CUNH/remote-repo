package com.fch.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @packageName com.fch.exception
 * @ClassName SystemException
 * @Description 自定义系统异常处理器
 * @Author Fan-CUNH
 * @Date 2023/7/6 11:26
 * @Version 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemException extends RuntimeException{
    /**
     * 状态码
     */
    private Integer code;

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
