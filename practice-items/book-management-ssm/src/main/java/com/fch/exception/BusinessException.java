package com.fch.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @packageName com.fch.exception
 * @ClassName BusinessException
 * @Description 自定义业务层异常处理器
 * @Author Fan-CUNH
 * @Date 2023/7/6 11:22
 * @Version 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{
    /**
     * 状态码
     */
    private Integer code;

    /**
     * @param message 提示消息
     * @param code 状态码
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @param code 状态码
     * @param message 提示消息
     * @param cause 异常信息
     */
    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
