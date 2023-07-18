package com.fch.controller;

import com.aliyuncs.exceptions.ClientException;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.constant.RedisConstant;
import com.fch.result.Result;
import com.fch.utils.SMSUtil;
import com.fch.utils.ValidateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @packageName com.fch.controller
 * @ClassName ValidateCodeController
 * @Description 随机验证码控制层
 * @Author Fan-CUNH
 * @Date 2023/7/17 19:35
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {

    @Resource
    private JedisPool jedisPool;

    @PostMapping("sendByOrder")
    public Result sendByOrder(String telephone) {
        Integer code = ValidateCodeUtil.generateValidateCode4Number(4);
        log.info("验证码 参数：{}", telephone);
        try {
            SMSUtil.sendMessage(SMSUtil.VALIDATE_CODE, telephone, code.toString());
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
        log.info("验证码 结果：{}", code);

        // 将验证码存入redis中
        jedisPool.getResource().setex(telephone+"_"+ RedisConstant.SENDTYPE_ORDER, 5 * 60, code.toString());

        return new Result(Code.GET_OK, Msg.SEND_VALIDATECODE_SUCCESS);
    }
}
