package com.fch.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.constant.RedisConstant;
import com.fch.domain.Member;
import com.fch.dto.LoginDTO;
import com.fch.result.Result;
import com.fch.service.MemberService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.Date;

/**
 * @packageName com.fch.controller
 * @ClassName MemberController
 * @Description 会员表现层
 * @Author Fan-CUNH
 * @Date 2023/7/18 14:10
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    @Reference
    private MemberService memberService;

    @Resource
    private JedisPool jedisPool;

    /**
     * 登录处理逻辑为：
     * 1、校验用户输入的短信验证码是否正确，如果验证码错误则登录失败
     * 2、如果验证码正确，则判断当前用户是否为会员，如果不是会员则自动完成会员注册
     * 3、向客户端写入Cookie，内容为用户手机号
     * 4、将会员信息保存到Redis，使用手机号作为key，保存时长为30分钟
     *
     * @param loginDTO 前端请求参数
     * @return 返回登录信息
     */
    @PostMapping("login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        log.info("登录 参数：{}", loginDTO);
        // 获取电话号码和验证码
        String telephone = loginDTO.getTelephone();
        String validateCode = loginDTO.getValidateCode();

        // 获取redis中存储的验证码
        Jedis jedis = jedisPool.getResource();
        String validateCodeFromRedis = jedis.get(telephone + "_" + RedisConstant.SENDTYPE_LOGIN);
        if (validateCode != null && validateCode.equals(validateCodeFromRedis)) {
            // 验证通过，判断当前登录手机号码是否是注册会员
            Member member = memberService.getMemberByTelephone(telephone);
            if (member == null) {
                // 不是会员，注册会员
                member.setRegTime(new Date());
                member.setPhoneNumber(telephone);
                memberService.add(member);
            }

            // 将手机号存入客户端浏览器
            Cookie loginMemberTelephone = new Cookie("login_member_telephone", telephone);
            // 路径
            loginMemberTelephone.setPath("/");
            // cookie 有效期
            loginMemberTelephone.setMaxAge(30 * 24 * 60 * 60);

            // 将会员信息存入redis
            jedis.setex(telephone, 30 *60, new Gson().toJson(member));

            return new Result(Code.GET_OK, Msg.LOGIN_SUCCESS, member      );
        } else {
            return new Result(Code.SAVE_ERR, Msg.LOGIN_FAIL);
        }
    }

    /**
     * 通过会员id查询会员信息
     *
     * @param id 会员id
     * @return 返回会员信息
     */
    @GetMapping("{id}")
    public Result getMemberById(@PathVariable("id") Integer id) {
        log.info("根据会员id查询会员信息 参数：{}", id);
        Member member = memberService.getMemberById(id);
        log.info("根据会员id查询会员信息 结果：{}", member);
        boolean flag = member != null;
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag ? Msg.QUERY_MEMBER_SUCCESS : Msg.QUERY_MEMBER_FAIL, member);
    }
}
