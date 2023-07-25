package com.fch.controller;

import com.fch.common.Code;
import com.fch.common.Result;
import com.fch.service.SecondKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/kill")
public class SecondKillController {
    @Resource
    private SecondKillService secondKillService;

    @PostMapping("{pid}")
    public Result secKill(@PathVariable("pid") String pid) {
        log.info("秒杀 入参:{}", pid);
        String uid = String.valueOf(UUID.randomUUID());
        Result result = secondKillService.secKill(uid, pid);
        log.info("秒杀 状态:{}", result.getMsg());
        return result;
    }
}
