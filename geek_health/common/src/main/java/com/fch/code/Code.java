package com.fch.code;

/**
 * @packageName com.fch.controller
 * @ClassName Code
 * @Description 统一返回结果状态码
 * @Author Fan-CUNH
 * @Date 2023/7/6 9:15
 * @Version 1.0
 */
public class Code {
    /**
     * 成功
     */
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    /**
     * 失败
     */
    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;


    /**
     * 系统异常
     */
    public static final Integer SYSTEM_ERR = 50001;
    /**
     * 系统超时
     */
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;
    /**
     * 未知系统异常
     */
    public static final Integer SYSTEM_UNKNOWN_ERR = 50003;
    /**
     * 业务异常
     */
    public static final Integer BUSINESS_ERR = 50001;
}
