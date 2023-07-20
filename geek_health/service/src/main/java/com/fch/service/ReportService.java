package com.fch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service
 * @ClassName ReportService
 * @Description 报表业务逻辑接口
 * @Author Fan-CUNH
 * @Date 2023/7/20 13:25
 * @Version 1.0
 */
public interface ReportService {
    /**
     * 通过月份查询每月会员数量
     *
     * @param months 月份集合
     * @return 返回每月对应的会员总量
     */
    List<Integer> getMemberCountByMonth(ArrayList<String> months);

    /**
     * @return 套餐预约占比
     */
    List<Map<String, Object>> getSetmealCountById();

    /**
     * 获取运营数据
     *
     * @return map集合
     */
    Map<String, Object> getBusinessReportData();
}
