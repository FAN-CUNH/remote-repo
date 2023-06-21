package com.fch.pojo;

/**
 * @packageName com.fch.pojo
 * @ClassName Result
 * @Description 统一响应结果类
 * @Author CunHao Fan
 * @data 2023/6/3 15:03
 * @Version 1.0
 */
public class Result {

    /**
     * 响应状态码
     *
     * 1: 成功
     * 0: 失败
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;


    /**
     * 无参构造方法
     */
    public Result() {
    }

    /**
     * 有参构造
     *
     * @param code 状态码
     * @param msg 提示信息
     * @param data 数据
     */
    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * Setter Getter 方法
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getdata() {
        return data;
    }

    public void setdata(Object data) {
        this.data = data;
    }

    /**
     * 响应成功返回客户端浏览器响应数据的静态方法
     *
     * @param data 响应数据
     * @return 返回响应结果对象
     */
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    /**
     * 响应成功不返回客户端浏览器响应数据的静态方法
     *
     * @return 返回响应结果对象
     */
    public static Result success() {
        return new Result(1, "success", null);
    }

    /**
     * 响应失败的静态方法
     *
     * @param msg 错误信息
     * @return 返回响应结果对象
     */
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    /**
     * 重写toString方法，将对象按字符串的方式输出出来。
     *
     * @return 返回对象信息
     */
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
