package com.fch.service;

import com.fch.domain.Ordersetting;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service
 * @ClassName OrdersettingService
 * @Description 预约设置接口
 * @Author Fan-CUNH
 * @Date 2023/7/14 10:06
 * @Version 1.0
 */
public interface OrdersettingService {
    /**
     * @param ordersettings 预约设置对象
     */
    void upload(List<Ordersetting> ordersettings);

    /**
     * 通过年月从数据库中查询预约设置信息
     *
     * @param year 年份
     * @param month 月份
     * @return 返回一个集合，集合中封装了预约设置信息
     */
    List<Map<String, Integer>> findDataByMonth(Integer year, Integer month);

    /**
     * 根据时间更新预约设置
     *
     * @param ordersetting 预约设置
     * @return 返回更新状态
     */
    boolean editNumberByDate(Ordersetting ordersetting);
}
