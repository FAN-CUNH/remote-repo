package com.fch.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.domain.Setmeal;
import com.fch.result.Result;
import com.fch.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName setmealController
 * @Description 移动端setmeal表现层
 * @Author Fan-CUNH
 * @Date 2023/7/15 16:08
 * @Version 1.0
 */
@Slf4j
// REST风格
@RestController
@RequestMapping("/setmeal")
public class setmealController {
    @Reference
    private SetmealService setmealService;

    @GetMapping("findAll")
    public Result findAll() {
        log.info("获取所有套餐信息");
        List<Setmeal> setmeals = setmealService.findAll();
        log.info("获取所有套餐信息 结果：{}", setmeals);
        return new Result(!CollectionUtil.isEmpty(setmeals) ? Code.GET_OK : Code.GET_ERR,
                !CollectionUtil.isEmpty(setmeals) ? Msg.QUERY_SETMEAL_SUCCESS : Msg.QUERY_SETMEAL_FAIL,
                setmeals);
    }
}
