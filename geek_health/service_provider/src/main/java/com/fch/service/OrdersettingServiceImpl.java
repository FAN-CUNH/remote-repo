package com.fch.service;

import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.fch.domain.Ordersetting;
import com.fch.domain.OrdersettingExample;
import com.fch.mapper.OrdersettingMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @packageName com.fch.service
 * @ClassName OrdersettingServiceImpl
 * @Description 预约设置接口实现
 * @Author Fan-CUNH
 * @Date 2023/7/14 10:05
 * @Version 1.0
 */
@Service
@Transactional
public class OrdersettingServiceImpl implements OrdersettingService {

    @Resource
    private OrdersettingMapper ordersettingMapper;

    /**
     * 通过上传的excel的文件内容来进行数据库的插入和更新
     * 如果文件中的数据库中存在，则执行更新操作
     * 如果不存在，则执行插入操作
     *
     * @param ordersettings 预约设置对象
     */
    @Override
    public void upload(List<Ordersetting> ordersettings) {
        // 参数校验
        if (ordersettings == null || ordersettings.size() == 0) {
            return;
        }

        // 调用插入/更新操作
        ordersettings.forEach(this::editOrdersetting);
    }

    /**
     * 更新预约设置
     *
     * @param ordersetting 预约设置
     */
    private boolean editOrdersetting(Ordersetting ordersetting) {
        Date orderDate = ordersetting.getOrderDate();
        // 封装条件
        OrdersettingExample ordersettingExample = new OrdersettingExample();
        OrdersettingExample.Criteria ordersettingExampleCriteria = ordersettingExample.createCriteria();
        ordersettingExampleCriteria.andOrderDateEqualTo(orderDate);

        int update = 0;
        int insert = 0;
        // 查询预约日期是否存储在数据库中
        int count = ordersettingMapper.countByExample(ordersettingExample);
        if (count > 0) {
            // 更新  已预约人数小于等于可预约人数，则更新 （即只有可预约范围之内的才进行更新）
            //需要更新的预约数量
            Integer number = ordersetting.getNumber();
            //通过预约日期，获取已预约数量
            Integer reservations = ordersettingMapper.selectByExample(ordersettingExample).get(0).getReservations();
            if (number >= reservations) {
                update = ordersettingMapper.updateByExampleSelective(ordersetting, ordersettingExample);
            }
        } else {
            // 插入
            insert = ordersettingMapper.insertSelective(ordersetting);
        }
        return update > 0 || insert > 0;
    }

    /**
     * 通过年月从数据库中查询预约设置信息
     *
     * @param year  年份
     * @param month 月份
     * @return 返回一个集合，集合中封装了预约设置信息
     */
    @Override
    public List<Map<String, Integer>> findDataByMonth(Integer year, Integer month) {
        // 获取查询日期的起始时间,并通过糊涂包将LocalDate转化成Date类型
        LocalDate beginDate = LocalDate.of(year, month, 1);
        Date begin = DateUtil.date(beginDate);
        // 获取查询日期的结束时间,通过糊涂包将LocalDate转化成Date类型
        LocalDate endDate = beginDate.with(TemporalAdjusters.lastDayOfMonth());
        Date end = DateUtil.date(endDate);

        // 封装查询条件
        OrdersettingExample ordersettingExample = new OrdersettingExample();
        OrdersettingExample.Criteria ordersettingExampleCriteria = ordersettingExample.createCriteria();
        ordersettingExampleCriteria.andOrderDateBetween(begin, end);

        // 查询
        List<Ordersetting> ordersettings = ordersettingMapper.selectByExample(ordersettingExample);

        // 将查询到的预约设置对象转换成 List<Map<String, Integer>>
        List<Map<String, Integer>> list = new ArrayList<>(32);
        //if (ordersettings != null && ordersettings.size() > 0) {
            ordersettings.forEach(ordersetting -> {
                // 将每天的数据封装成一个map集合
                Map<String, Integer> map = new HashMap<>(32);
                // 获取当天的日期、可预约人数、已预约人数  将其封装入同一个map,然后塞入list中
                map.put("date", DateUtil.dayOfMonth(ordersetting.getOrderDate()));
                map.put("number", ordersetting.getNumber());
                map.put("reservations", ordersetting.getReservations());
                list.add(map);
            });
        //}
        return list;
    }

    /**
     * 根据时间更新预约设置
     *
     * @param ordersetting 预约设置
     * @return 返回更新状态
     */
    @Override
    public boolean editNumberByDate(Ordersetting ordersetting) {
        return editOrdersetting(ordersetting);
}
}
