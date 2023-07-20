package com.fch.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.fch.domain.Member;
import com.fch.domain.MemberExample;
import com.fch.mapper.MemberMapper;
import com.fch.utils.MD5Util;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName MemberServiceImpl
 * @Description 服务接口实现
 * @Author Fan-CUNH
 * @Date 2023/7/18 14:13
 * @Version 1.0
 */
@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService{

    @Resource
    private MemberMapper memberMapper;

    /**
     * 通过手机号码查询绑定的会员信息
     *
     * @param telephone 电话号码
     * @return 返回会员信息
     */
    @Override
    public Member getMemberByTelephone(String telephone) {
        // 封装查询条件
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria memberExampleCriteria = memberExample.createCriteria();
        memberExampleCriteria.andPhoneNumberEqualTo(telephone);

        // 查询
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (CollectionUtil.isNotEmpty(members)) {
            // 由于手机号是唯一绑定会员的，所以集合只有一个元素，直接返回get(0)
            return members.get(0);
        }
        return null;
    }

    /**
     * 快速新增会员
     *
     * @param member 会员信息载体
     */
    @Override
    public void add(Member member) {
        String password = member.getPassword();
        if (StringUtils.hasLength(password)) {
            // 使用MD5对密码进行加密
            password = MD5Util.md5(password);
            member.setPassword(password);
        }

        memberMapper.insertSelective(member);
    }

    /**
     * 通过会员id查询会员信息
     *
     * @param id 会员id
     * @return 返回会员信息
     */
    @Override
    public Member getMemberById(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}
