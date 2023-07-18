package com.fch.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.domain.*;
import com.fch.mapper.MemberMapper;
import com.fch.mapper.OrdersMapper;
import com.fch.mapper.OrdersettingMapper;
import com.fch.result.Result;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service
 * @ClassName OrdersServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/17 20:45
 * @Version 1.0
 */
@Service(interfaceClass = OrdersService.class)
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OrdersettingMapper ordersettingMapper;

    @Resource
    private MemberMapper memberMapper;

    /**
     * 1、检查用户所选择的预约日期是否已经提前进行了预约设置，如果没有设置则无法进行预约
     * 2、检查用户所选择的预约日期是否已经约满，如果已经约满则无法预约
     * 3、检查用户是否重复预约（同一个用户在同一天预约了同一个套餐），如果是重复预约则无法完成再次预约
     * 4、检查当前用户是否为会员，如果是会员则直接完成预约，如果不是会员则自动完成注册并进行预约
     * 5、预约成功，更新当日的已预约人数
     *
     * @param map 前端请求参数
     * @return 返回预约状态
     */
    @Override
    public Result submit(Map<String, Object> map) {
        // 1、检查用户所选择的预约日期是否已经提前进行了预约设置，如果没有设置则无法进行预约
        // 获取用户页面输入的预约日期
        Date orderDate = DateUtil.parse((String) map.get("orderDate"), "yyyy-MM-dd");

        // 封装查询条件
        OrdersettingExample ordersettingExample = new OrdersettingExample();
        OrdersettingExample.Criteria ordersettingExampleCriteria = ordersettingExample.createCriteria();
        ordersettingExampleCriteria.andOrderDateEqualTo(orderDate);

        // 查询
        List<Ordersetting> ordersettings = ordersettingMapper.selectByExample(ordersettingExample);
        if (CollectionUtil.isEmpty(ordersettings)) {
            // 指定日期没有进行预约设置，无法完成体检预约
            return new Result(Code.GET_ERR, Msg.SELECTED_DATE_CANNOT_ORDER);
        }

        // 2、检查用户所选择的预约日期是否已经约满，如果已经约满则无法预约
        Ordersetting ordersetting = ordersettings.get(0);
        // 可预约人数
        Integer number = ordersetting.getNumber();
        // 已预约人数
        Integer reservations = ordersetting.getReservations();
        if (number <= reservations) {
            // 已约满 无法预约
            return new Result(Code.GET_ERR, Msg.ORDER_FULL);
        }

        // 3、检查用户是否重复预约（同一个用户在同一天预约了同一个套餐），如果是重复预约则无法完成再次预约  会员ID、套餐ID、预约日期
        // 根据电话号码判断当前用户是否是会员
        String telephone = (String) map.get("telephone");
        // 获取套餐id
        String setmealId = (String) map.get("setmealId");
        // 封装查询条件
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria memberExampleCriteria = memberExample.createCriteria();
        memberExampleCriteria.andPhoneNumberEqualTo(telephone);
        // 查询是否是会员
        List<Member> members = memberMapper.selectByExample(memberExample);
        Member member;
        if (CollectionUtil.isEmpty(members)) {
            // 不是会员，注册会员
            member = new Member(((String) map.get("name")), ((String) map.get("sex")), ((String) map.get("idCard")), telephone, new Date());
            memberMapper.insertSelective(member);
        } else {
            member = members.get(0);
            Integer memberId = member.getId();
            // 封装查询条件
            OrdersExample ordersExample = new OrdersExample();
            OrdersExample.Criteria ordersExampleCriteria = ordersExample.createCriteria();
            ordersExampleCriteria.andIdEqualTo(memberId);
            ordersExampleCriteria.andSetmealIdEqualTo(Integer.parseInt(setmealId));
            ordersExampleCriteria.andOrderDateEqualTo(orderDate);

            // 查询
            List<Orders> orderss = ordersMapper.selectByExample(ordersExample);
            if (CollectionUtil.isNotEmpty(orderss)) {
                // 重复预约
                return new Result(Code.GET_ERR, Msg.HAS_ORDERED);
            }
        }
        // 5、预约成功，更新当日的已预约人数
        Orders orders = new Orders(member.getId(), orderDate, ((String) map.get("orderType")), ((String) map.get("orderStatus")), Integer.parseInt(setmealId));
        ordersMapper.insertSelective(orders);

        // 预约人数 +1
        ordersetting.setReservations(ordersetting.getReservations() + 1);
        int update = ordersettingMapper.updateByExampleSelective(ordersetting, ordersettingExample);

        return new Result(update > 0 ? Code.GET_OK : Code.GET_ERR, update > 0 ? Msg.ORDER_SUCCESS : Msg.ORDER_FAIL, orders.getId());
    }

    /**
     * 通过订单id查询订单信息
     *
     * @param id 订单id
     * @return 返回查询到的会员信息
     */
    @Override
    public Map<String, Object> getOrdersById(Integer id) {
        Map<String, Object> map = ordersMapper.selectByOrdersId(id);

        // 格式化日期 避免前端读取时间出现时间戳
        if (CollectionUtil.isNotEmpty(map)) {
            map.put("ordersDate", DateUtil.format((Date) map.get("ordersDate"), "yyyy-MM-dd"));
        }
        return map;
    }
}
