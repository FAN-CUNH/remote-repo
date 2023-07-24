package com.fch.controller;

import com.fch.common.Code;
import com.fch.common.Result;
import com.fch.service.SecondKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @packageName com.fch.controller
 * @ClassName SecondKillController
 * @Description 秒杀活动控制层
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:09
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/secKill")
public class SecondKillController {
    @Resource
    private SecondKillService secondKillService;

    @PostMapping("{id}")
    public Result secKill(@PathVariable("id") Integer id) {
        log.info("秒杀 入参:{}", id);
        String uid = String.valueOf(UUID.randomUUID());
        Result result = secondKillService.secKill(uid, id);
        log.info("秒杀 状态:{}", result.getMsg());
        return result;
    }
}
