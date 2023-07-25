package com.fch.service;

import com.fch.common.Result;

/**
 * @packageName com.fch.service
 * @ClassName SecondKillService
 * @Description 秒杀活动服务接口层
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:10
 * @Version 1.0
 */
public interface SecondKillService {
    /**
     * 秒杀
     *
     * @param id 商品id
     * @return
     */
    Result secKill(String uid, String id);
}
