package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.bean
 * @ClassName Result
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:52
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 增删改成功响应结果
     *
     * @return
     */
    public static Result success() {
        return new Result(1, "success", null);
    }

    /**
     * 查成功响应结果
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    /**
     * 失败响应
     *
     * @param msg
     * @return
     */
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}
