package com.fch.service;


/**
 * @packageName com.fch.service
 * @ClassName ValidateCodeService
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 18:53
 * @Version 1.0
 */
public interface ValidateCodeService {
    /**
     * 新增验证码
     *
     * @param telephone 手机号
     * @return 新增状态
     */
    boolean saveValidateCode(String telephone);

    /**
     * 根据手机号获取验证码
     *
     * @param telephone 手机号
     * @return 验证码
     */
    String getValidateCode(String telephone);
}
