package com.fch.controller;

import com.fch.code.Code;
import com.fch.exception.BusinessException;
import com.fch.exception.SystemException;
import com.fch.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @packageName com.fch.controller
 * @ClassName ExceptionAdvice
 * @Description 异常处理通知类
 * @Author Fan-CUNH
 * @Date 2023/7/6 11:19
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice // 标识此类为REST风格的异常处理器 此注解自带@ResponseBody注解与@Component注解
public class ExceptionAdvice {
    /**
     * 处理系统异常
     *
     * @param systemException 系统异常
     * @return 返回统一响应结果
     */
    @ExceptionHandler(SystemException.class) // 设置当前处理器类对应的异常类型
    public Result doSystemException(SystemException systemException) {
        return new Result(systemException.getCode(), null, systemException.getMessage());
    }

    /**
     * 处理业务异常
     *
     * @param businessException 业务异常
     * @return 统一响应结果
     */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException businessException) {
        return new Result(businessException.getCode(), null, businessException.getMessage());
    }

    /**
     * 处理未知异常
     *
     * @param exception 未知异常
     * @return 统一响应结果
     */
    /*@ExceptionHandler(Exception.class)
    public Result doOtherException(Exception exception) {
        log.error(exception.getMessage());
        return new Result(Code.SYSTEM_ERR, "系统繁忙，请稍后重试！", null);
    }*/
}
