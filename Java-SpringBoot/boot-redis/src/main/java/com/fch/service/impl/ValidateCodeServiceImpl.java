package com.fch.service.impl;

import com.fch.service.ValidateCodeService;
import io.netty.util.internal.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @packageName com.fch.service.impl
 * @ClassName ValidateCodeServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 18:58
 * @Version 1.0
 */
@Service
@Slf4j
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 新增验证码
     *
     * @param telephone 手机号
     * @return 新增状态
     */
    @Override
    public boolean saveValidateCode(String telephone) {
        int validateCode = ThreadLocalRandom.current().nextInt(1000) + 1;
        log.info("生成的验证码：{}",validateCode);
        redisTemplate.opsForValue().set(telephone, validateCode);
        return true;
    }

    /**
     * 根据手机号获取验证码
     *
     * @param telephone 手机号
     * @return 验证码
     */
    @Override
    public String getValidateCode(String telephone) {
        return (redisTemplate.opsForValue().get(telephone) + "");
    }
}
