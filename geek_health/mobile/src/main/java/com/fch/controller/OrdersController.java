package com.fch.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.exceptions.ClientException;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.constant.RedisConstant;
import com.fch.domain.Member;
import com.fch.domain.Orders;
import com.fch.result.Result;
import com.fch.service.OrdersService;
import com.fch.utils.SMSUtil;
import com.fch.utils.ValidateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @packageName com.fch.controller
 * @ClassName OrdersController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/17 20:44
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Reference
    public OrdersService ordersService;

    @Resource
    public JedisPool jedisPool;

    /**
     * @param map 前端请求参数
     * @return 返回预约状态
     */
    @PostMapping("submit")
    public Result submit(@RequestBody Map<String, Object> map) {
        // 从Redis中获取保存的验证码
        String telephone = (String) map.get("telephone");
        String validateCodeFromRedis = jedisPool.getResource().get(telephone + "_" + RedisConstant.SENDTYPE_ORDER);

        // 获取页面中的验证码 进行对比
        String validateCode = (String) map.get("validateCode");
        Result result;
        if (validateCode != null && validateCode.equals(validateCodeFromRedis)) {
            // 如果比对成功，设置预约类型，设置预约状态，然后调用服务完成预约业务处理
            map.put("orderType", Orders.ORDER_TYPE_WEIXIN);
            map.put("orderStatus", Orders.ORDER_STATUS_NO);
            result = ordersService.submit(map);
            if (Code.GET_OK.equals(result.getCode())) {
                // 预约成功，发送短信
                try {
                    SMSUtil.sendMessage(SMSUtil.VALIDATE_CODE, telephone, ValidateCodeUtil.generateValidateCode4Number(4).toString());
                } catch (ClientException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            result = new Result(Code.GET_ERR, Msg.VALIDATECODE_ERROR);
        }
        return result;
    }

    /**
     * 通过预约id查询订单信息
     *
     * @param id 预约id
     * @return 返回查询到的会员信息
     */
    @GetMapping("{id}")
    public Result getMemberById(@PathVariable("id") Integer id) {
        log.info("获取预约成功的页面信息 参数：{}", id);
        Map<String, Object> map = ordersService.getOrdersById(id);
        boolean flag = map != null;
        log.info("获取预约成功的页面信息 结果：{}", map);
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag ? Msg.QUERY_ORDER_SUCCESS : Msg.QUERY_ORDER_FAIL, map);
    }
}
