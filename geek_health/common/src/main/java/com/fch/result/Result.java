package com.fch.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @packageName com.fch.result
 * @ClassName Result
 * @Description 封装通用返回结果
 * @Author Fan-CUNH
 * @Date 2023/7/8 20:14
 * @Version 1.0
 */

@Data
public class Result implements Serializable {
    /**
     * 返回执行结果，true为执行成功 false为执行失败
     */
    private Integer code;

    /**
     * 返回提示信息，主要用于页面提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
