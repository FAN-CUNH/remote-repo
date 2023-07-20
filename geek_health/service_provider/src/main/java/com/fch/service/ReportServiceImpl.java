package com.fch.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.fch.constant.Msg;
import com.fch.domain.MemberExample;
import com.fch.domain.Orders;
import com.fch.domain.OrdersExample;
import com.fch.domain.SetmealExample;
import com.fch.mapper.MemberMapper;
import com.fch.mapper.OrdersMapper;
import com.fch.mapper.SetmealMapper;

import javax.annotation.Resource;
import java.util.*;

/**
 * @packageName com.fch.service
 * @ClassName ReportServiceImpl
 * @Description 报表业务逻辑接口实现层
 * @Author Fan-CUNH
 * @Date 2023/7/20 13:26
 * @Version 1.0
 */
@Service(interfaceClass = ReportService.class)
public class ReportServiceImpl implements ReportService{
    @Resource
    private MemberMapper memberMapper;

    @Resource
    private SetmealMapper setmealMapper;

    @Resource
    private OrdersMapper ordersMapper;

    /**
     * 通过月份查询每月会员数量
     *
     * @param months 月份集合
     * @return 返回每月对应的会员总量
     */
    @Override
    public List<Integer> getMemberCountByMonth(ArrayList<String> months) {
        List<Integer> memberCount;
        if (months != null) {
            memberCount = new ArrayList<>(16);
            months.forEach(s -> {
                // 获取当前日期的最后一天并别转化成yyyy-MM-dd 23:59:59的形式
                Date endOfMonth = DateUtil.endOfMonth(DateUtil.parse(s, "yyyy.MM"));
                // 查询
                MemberExample memberExample = new MemberExample();
                MemberExample.Criteria memberExampleCriteria = memberExample.createCriteria();
                memberExampleCriteria.andRegTimeLessThanOrEqualTo(endOfMonth);
                int count = memberMapper.countByExample(memberExample);
                memberCount.add(count);
            });
        } else {
            memberCount = null;
        }
        return memberCount;
    }

    /**
     * 根据id分组获取每个套餐预约的占比数量
     *
     * @return 套餐预约占比
     */
    @Override
    public List<Map<String, Object>> getSetmealCountById() {
        return setmealMapper.getSetmealCountById();
    }

    /**
     * 获取运营数据
     *
     * @return map集合
     * "todayVisitsNumber":0,       报表日期
     * "reportDate":"2019-04-25",   今日新增会员数
     * "todayNewMember":0,          总会员数
     * "thisWeekNewMember":0,    本周新增会员数
     * "thisMonthNewMember":2,      本月新增会员数
     * "todayOrderNumber":0,        今日预约量
     * "todayVisitsNumber":10,      今日到诊数
     * "thisWeekOrderNumber":2,     本周预约量
     * "thisWeekVisitsNumber":0,    本周到诊数
     * "thisMonthOrderNumber":0,    本月预约量
     * "thisMonthVisitsNumber":0,   本月到诊数
     * "hotSetmeal":[
     *   {"proportion":0.4545,"name":"粉红珍爱(女)升级TM12项筛查体检套餐","setmeal_count":5},
     *   {"proportion":0.1818,"name":"阳光爸妈升级肿瘤12项筛查体检套餐","setmeal_count":2},
     *   {"proportion":0.1818,"name":"珍爱高端升级肿瘤12项筛查","setmeal_count":2},
     *   {"proportion":0.0909,"name":"孕前检查套餐","setmeal_count":1}
     * ],
     */
    @Override
    public Map<String, Object> getBusinessReportData() {

        // 时间
        // 今日时间
        Date today = DateUtil.parse(DateUtil.now(), "yyyy-MM-dd");
        // 本周开始时间
        Date beginOfWeek = DateUtil.beginOfWeek(today);
        // 本周结束时间
        Date endedOfWeek = DateUtil.endOfWeek(today);
        // 本月开始时间
        Date beginOfMonth = DateUtil.beginOfMonth(today);
        // 本月结束时间
        Date endOfMonth = DateUtil.endOfMonth(today);

        // map集合用于存储运营数据
        Map<String, Object> data = new HashMap<>(16);

        // 日期
        data.put("reportDate", DateUtil.format(today, "yyyy-MM-dd"));

        // 会员
        // "todayNewMember" 今日新增会员数
        MemberExample memberExample1 = new MemberExample();
        MemberExample.Criteria memberExample1Criteria = memberExample1.createCriteria();
        memberExample1Criteria.andRegTimeLessThanOrEqualTo(today);
        int count = memberMapper.countByExample(memberExample1);
        data.put("todayNewMember", count);
        // "todayNewMember" 总会员数
        int count1 = memberMapper.countByExample(null);
        data.put("totalMember", count1);
        // "thisWeekVisitsNumber" 本周新增会员数
        MemberExample memberExample2 = new MemberExample();
        MemberExample.Criteria memberExample2Criteria = memberExample2.createCriteria();
        memberExample2Criteria.andRegTimeBetween(beginOfWeek, endedOfWeek);
        int count2 = memberMapper.countByExample(memberExample2);
        data.put("thisWeekNewMember", count2);
        // "thisMonthNewMember" 本月新增会员数
        MemberExample memberExample3 = new MemberExample();
        MemberExample.Criteria memberExample3Criteria = memberExample3.createCriteria();
        memberExample3Criteria.andRegTimeBetween(beginOfMonth, endOfMonth);
        data.put("thisMonthNewMember", memberMapper.countByExample(memberExample3));

        // 预约
        //  "todayOrderNumber" 今日预约量
        OrdersExample ordersExample1 = new OrdersExample();
        OrdersExample.Criteria ordersExample1Criteria = ordersExample1.createCriteria();
        ordersExample1Criteria.andOrderDateEqualTo(today);
        data.put("todayOrderNumber", ordersMapper.countByExample(ordersExample1));
        // "todayVisitsNumber" 今日到诊数
        ordersExample1Criteria.andOrderStatusEqualTo(Orders.ORDER_STATUS_YES);
        data.put("todayVisitsNumber", ordersMapper.countByExample(ordersExample1));
        // "thisWeekOrderNumber"  本周预约量
        OrdersExample ordersExample2 = new OrdersExample();
        OrdersExample.Criteria ordersExample2Criteria = ordersExample2.createCriteria();
        ordersExample2Criteria.andOrderDateBetween(beginOfWeek, endedOfWeek);
        data.put("thisWeekOrderNumber", ordersMapper.countByExample(ordersExample2));
        // "thisWeekVisitsNumber" 本周到诊数
        ordersExample2Criteria.andOrderStatusEqualTo(Orders.ORDER_STATUS_YES);
        data.put("thisWeekVisitsNumber", ordersMapper.countByExample(ordersExample2));
        // "thisMonthOrderNumber" 本月预约量
        OrdersExample ordersExample3 = new OrdersExample();
        OrdersExample.Criteria ordersExample3Criteria = ordersExample3.createCriteria();
        ordersExample3Criteria.andOrderDateBetween(beginOfMonth, endOfMonth);
        data.put("thisMonthOrderNumber", ordersMapper.countByExample(ordersExample3));
        // "thisMonthVisitsNumber" 本月到诊数
        ordersExample3Criteria.andOrderStatusEqualTo(Orders.ORDER_STATUS_YES);
        data.put("thisMonthVisitsNumber", ordersMapper.countByExample(ordersExample3));

        // 热门套餐
        data.put("hotSetmeal", setmealMapper.getHotSetmeal());
        return data;
    }
}
