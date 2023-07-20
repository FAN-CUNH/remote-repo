package com.fch.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.domain.Ordersetting;
import com.fch.result.Result;
import com.fch.service.OrdersettingService;
import com.fch.utils.POIUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @packageName com.fch.controller
 * @ClassName OrdersettingController
 * @Description 预约设置
 * @Author Fan-CUNH
 * @Date 2023/7/14 10:04
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/ordersetting")
public class OrdersettingController {

    /**
     * Dubbo服务提供方
     */
    @Reference
    private OrdersettingService ordersettingService;

    /**
     * @param excelFile excel文件对象
     * @return 返回统一响应结果
     */
    @RolesAllowed({"HEALTH_MANAGER"})
    @PostMapping("upload")
    public Result upload(@RequestPart("excelFile") MultipartFile excelFile) throws IOException {
        // 使用POI解析Excel表格和数据
        List<String[]> excelContext = POIUtil.readExcel(excelFile);

        // 将读取到的内容转换成预约设置对象集合
        List<Ordersetting> ordersettings = excelContext.stream()
                .map(orderSetting -> new Ordersetting(
                        DateUtil.parse(orderSetting[0], "yyyy.MM.dd"),
                        Integer.valueOf(orderSetting[1]),
                        0))
                .collect(Collectors.toList());

        try {
            // 实现数据批量导入到数据库
            ordersettingService.upload(ordersettings);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Code.SAVE_ERR, Msg.IMPORT_ORDERSETTING_FAIL);
        }
        return new Result(Code.SAVE_OK, Msg.IMPORT_ORDERSETTING_SUCCESS);
    }

    /**
     * 通过年月从数据库中查询预约设置信息
     *
     * @param year  年份
     * @param month 月份
     * @return 返回统一响应结果
     */
    @GetMapping("findDataByMonth/{year}/{month}")
    public Result findDataByMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        log.info("根据时间查询预约设置信息 参数：{}", year +"-"+ month);
        List<Map<String, Integer>> list = ordersettingService.findDataByMonth(year, month);
        log.info("根据时间查询预约设置信息 结果：{}", list);
        if (list != null && list.size() > 0) {
            return new Result(Code.GET_OK, Msg.GET_ORDERSETTING_SUCCESS, list);
        }
        return new Result(Code.GET_ERR, Msg.GET_ORDERSETTING_FAIL);
    }

    /**
     * 根据时间更新预约设置的可预约人数
     *
     * @param ordersetting 预约设置
     * @return 返回统一响应数据
     */
    @RolesAllowed({"HEALTH_MANAGER"})
    @PutMapping("editNumberByDate")
    public Result editNumberByDate(@RequestBody Ordersetting ordersetting) {
        log.info("更新预约设置 参数：{}", ordersetting);
        boolean flag = ordersettingService.editNumberByDate(ordersetting);
        log.info("更新预约设置 状态：{}", flag);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag ? Msg.ORDERSETTING_SUCCESS : Msg.ORDERSETTING_FAIL);
    }
}
