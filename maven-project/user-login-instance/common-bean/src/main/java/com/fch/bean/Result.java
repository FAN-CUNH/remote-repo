package com.fch.bean;

/**
 * @packageName com.fch.entity
 * @ClassName Result
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/12 10:01
 * @Version 1.0
 */
public class Result<T> {

    public Result() {
    }

    /*
        SUCCESS(20000,"正常"),NOTFOUND(404,"找不到资源"),
        SERVERERROR(500,"服务器内部错误"),
        URLERROR(400,"前端请求url错误");
    */
    public Result(int code, T data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private int code;
    private String msg;
    private T data;


    /**
     * 获取
     *
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "Result{code = " + code + ", msg = " + msg + ", data = " + data + "}";
    }
}
