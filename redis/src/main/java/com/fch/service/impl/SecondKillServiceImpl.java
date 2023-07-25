package com.fch.service.impl;

import com.fch.common.Code;
import com.fch.common.Msg;
import com.fch.common.Result;
import com.fch.service.SecondKillService;
import com.fch.utils.LuaUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @packageName com.fch.service.impl
 * @ClassName SecondKillServiceImpl
 * @Description 秒杀活动接口实现层
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:12
 * @Version 1.0
 */
@Service
public class SecondKillServiceImpl implements SecondKillService {
    @Resource
    private JedisPool jedisPool;

    /**
     * @param uid 用户id
     * @param pid 商品id
     * @return
     */
    @Override
    public Result secKill(String uid, String pid) {
        Long o = LuaUtil.loadScript(jedisPool, "secondKill.lua", 2, pid, uid);
        if (o != null) {
            if (o == 1) {
                //1.未发现库存 商品已下架
                return new Result(Code.KILL_ERR, Msg.ITEM_HAS_BEEN_REMOVED);
            } else if (o == 2) {
                //2.库存<=0 活动已结束
                return new Result(Code.KILL_ERR, Msg.THE_EVENT_HAS_ENDED);
            } else if (o == 3) {
                //3.用户编号已经在Redis中 秒杀失败，你已参与秒杀活动，限购一单
                return new Result(Code.KILL_ERR, Msg.YOU_ARE_ALREADY_INVOLVED_IN_AN_EVENT);
            } else if (o == 4) {
                //4.秒杀成功
                return new Result(Code.KILL_OK, Msg.SECOND_KILL_SUCCESS);
            }
        }
        return new Result(Code.KILL_ERR, "系统繁忙，请稍后重试！");
    }
}
