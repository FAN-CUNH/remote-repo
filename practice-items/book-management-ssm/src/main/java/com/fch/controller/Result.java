package com.fch.controller;

import lombok.Data;

/**
 * @packageName com.fch.controller
 * @ClassName Result
 * @Description 统一数据返回结果类
 * @Author Fan-CUNH
 * @Date 2023/7/6 9:02
 * @Version 1.0
 */

@Data
public class Result {
    /**
     * 统一返回结果格式中的状态码
     */
    private Integer code;
    /**
     * 统一返回结果格式中的返回数据
     */
    private Object data;
    /**
     *  统一返回结果格式中的提示消息
     */
    private String msg;

    /**
     * 空参构造
     */
    public Result() {
    }

    /**
     * 返回成功消息
     *
     * @param code 状态码
     * @param data 数据
     */
    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @param code 状态码
     * @param data 数据
     * @param msg 提示消息
     */
    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
