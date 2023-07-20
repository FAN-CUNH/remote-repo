package com.fch.service;

import com.fch.domain.Member;

/**
 * @packageName com.fch.service
 * @ClassName MemberService
 * @Description 服务接口
 * @Author Fan-CUNH
 * @Date 2023/7/18 14:12
 * @Version 1.0
 */
public interface MemberService {
    /**
     * 通过手机号码查询绑定的会员信息
     *
     * @param telephone 电话号码
     * @return 返回会员信息
     */
    Member getMemberByTelephone(String telephone);

    /**
     * 快速新增会员
     *
     * @param member 会员信息载体
     */
    void add(Member member);

    /**
     * 通过会员id查询会员信息
     *
     * @param id 会员id
     * @return 返回会员信息
     */
    Member getMemberById(Integer id);
}
