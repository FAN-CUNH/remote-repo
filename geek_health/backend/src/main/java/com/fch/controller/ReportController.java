package com.fch.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.result.Result;
import com.fch.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @packageName com.fch.controller
 * @ClassName ReportController
 * @Description 报表表现层 处理前端请求以及响应数据
 * @Author Fan-CUNH
 * @Date 2023/7/20 13:23
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/report")
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true)
public class ReportController {
    @Reference
    private ReportService reportService;

    /**
     * 查询每月会员数量
     * 返回数据形式：
     * {
     * months: [], 当前日期之前一年的年、月份
     * memberCount: [] 每月对应的会员数量
     * }
     *
     * @return 返回会员报表数据
     */
    @GetMapping("getMemberReport")
    public Result getMemberReport() {
        Map<String, Object> map = new HashMap<>(16);

        // 获取months
        ArrayList<String> months = new ArrayList<>(16);
        // 获取当前年份之前的一年 即当前日期2023-7-20之前一年 2022-7-20
        LocalDate minusYears = LocalDate.now().minusYears(1);
        // 对minusYears的月份处理，并且格式化日期格式
        for (int i = 1; i <= 12; i++) {
            // 将2022-7-20逐月递增 —> 2022-8-20 -> 2022-9-20
            LocalDate plusMonths = minusYears.plusMonths(i);
            String date = DateUtil.format(DateUtil.date(plusMonths), "yyyy.MM");
            months.add(date);
        }
        map.put("months", months);

        // 获取memberCount
        List<Integer> memberCount = reportService.getMemberCountByMonth(months);
        map.put("memberCount", memberCount);

        boolean flag = memberCount != null;

        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag ? Msg.GET_MEMBER_NUMBER_REPORT_SUCCESS : Msg.GET_MEMBER_NUMBER_REPORT_FAIL, map);
    }

    /**
     * 查询套餐预约占比数据
     * 返回数据形式：
     *
     * @return
     * {
     *       	"data":{
     *       			"setmealNames":["套餐1","套餐2","套餐3"],
     *       			"setmealCount":[
     *                                  {"name":"套餐1","value":10},
     *                                  {"name":"套餐2","value":30},
     *                                  {"name":"套餐3","value":25}
     *       						   ]
     *       		   },
     *      	"code":20041,
     *       	"msg":"获取套餐统计数据成功"
     *       }
     */
    @GetMapping("getSetmealReport")
    public Result getSetmealReport() {
        try {
            Map<String, Object> data = new HashMap<>(16);

            // 获取 setmealCount
            List<Map<String, Object>> setmealCount = reportService.getSetmealCountById();
            // 获取 setmealNames
            List<String> setmealNames = setmealCount.stream()
                    .map(stringIntegerMap -> (String) stringIntegerMap.get("name"))
                    .collect(Collectors.toList());
            data.put("setmealNames", setmealNames);
            data.put("setmealCount", setmealCount);
            return new Result(Code.GET_OK, Msg.GET_SETMEAL_COUNT_REPORT_SUCCESS, data);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result(Code.GET_ERR, Msg.GET_SETMEAL_COUNT_REPORT_FAIL);
        }
    }

    /**
     * @return
     * {
     *   "data":{
     *     "todayVisitsNumber":0,       报表日期
     *     "reportDate":"2019-04-25",   今日新增会员数
     *     "todayNewMember":0,          总会员数
     *     "thisWeekVisitsNumber":0,    本周新增会员数
     *     "thisMonthNewMember":2,      本月新增会员数
     *     "thisWeekNewMember":0,       今日预约量
     *     "totalMember":10,            今日到诊数
     *     "thisMonthOrderNumber":2,    本周预约量
     *     "thisMonthVisitsNumber":0,   本周到诊数
     *     "todayOrderNumber":0,        本月预约量
     *     "thisWeekOrderNumber":0,     本月到诊数
     *     "hotSetmeal":[
     *       {"proportion":0.4545,"name":"粉红珍爱(女)升级TM12项筛查体检套餐","setmeal_count":5},
     *       {"proportion":0.1818,"name":"阳光爸妈升级肿瘤12项筛查体检套餐","setmeal_count":2},
     *       {"proportion":0.1818,"name":"珍爱高端升级肿瘤12项筛查","setmeal_count":2},
     *       {"proportion":0.0909,"name":"孕前检查套餐","setmeal_count":1}
     *     ],
     *   },
     *   "code":true,
     *   "msg":"获取运营统计数据成功"
     * }
     */
    @GetMapping("getBusinessReportData")
    public Result getBusinessReportData() {
        try {
            Map<String, Object> data = reportService.getBusinessReportData();
            return new Result(Code.GET_OK, Msg.GET_BUSINESS_REPORT_SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Code.GET_ERR, Msg.GET_BUSINESS_REPORT_FAIL);
        }
    }

    /**
     * @param req 请求
     * @param res 响应
     * @return 状态
     */
    @GetMapping("exportBusinessReport")
    public Result exportBusinessReport(HttpServletRequest req, HttpServletResponse res) {
        try {
            Map<String, Object> data = reportService.getBusinessReportData();
            //取出返回结果数据，准备将报表数据写入到Excel文件中
            String reportDate = (String) data.get("reportDate");
            Integer todayNewMember = (Integer) data.get("todayNewMember");
            Integer totalMember = (Integer) data.get("totalMember");
            Integer thisWeekNewMember = (Integer) data.get("thisWeekNewMember");
            Integer thisMonthNewMember = (Integer) data.get("thisMonthNewMember");
            Integer todayOrderNumber = (Integer) data.get("todayOrderNumber");
            Integer thisWeekOrderNumber = (Integer) data.get("thisWeekOrderNumber");
            Integer thisMonthOrderNumber = (Integer) data.get("thisMonthOrderNumber");
            Integer todayVisitsNumber = (Integer) data.get("todayVisitsNumber");
            Integer thisWeekVisitsNumber = (Integer) data.get("thisWeekVisitsNumber");
            Integer thisMonthVisitsNumber = (Integer) data.get("thisMonthVisitsNumber");
            List<Map<String, Object>> hotSetmeal = (List<Map<String, Object>>) data.get("hotSetmeal");

            // 获取Excel模版的位置
            String path = req.getSession().getServletContext().getRealPath("/template") + File.separator + "report_template.xlsx";
            log.info("path:{}", path);

            //读取模板文件创建Excel表格对象
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path));
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow row = sheet.getRow(2);
            row.getCell(5).setCellValue(reportDate);//日期

            row = sheet.getRow(4);
            row.getCell(5).setCellValue(todayNewMember);//新增会员数（本日）
            row.getCell(7).setCellValue(totalMember);//总会员数

            row = sheet.getRow(5);
            row.getCell(5).setCellValue(thisWeekNewMember);//本周新增会员数
            row.getCell(7).setCellValue(thisMonthNewMember);//本月新增会员数

            row = sheet.getRow(7);
            row.getCell(5).setCellValue(todayOrderNumber);//今日预约数
            row.getCell(7).setCellValue(todayVisitsNumber);//今日到诊数

            row = sheet.getRow(8);
            row.getCell(5).setCellValue(thisWeekOrderNumber);//本周预约数
            row.getCell(7).setCellValue(thisWeekVisitsNumber);//本周到诊数

            row = sheet.getRow(9);
            row.getCell(5).setCellValue(thisMonthOrderNumber);//本月预约数
            row.getCell(7).setCellValue(thisMonthVisitsNumber);//本月到诊数

            int rowNum = 12;
            for(Map<String, Object> hotSetmealMap : hotSetmeal){ // 热门套餐
                String name = (String) hotSetmealMap.get("name");
                Long setmeal_count = (Long) hotSetmealMap.get("setmeal_count");
                BigDecimal proportion = (BigDecimal) hotSetmealMap.get("proportion");
                row = sheet.getRow(rowNum ++);
                row.getCell(4).setCellValue(name);//套餐名称
                row.getCell(5).setCellValue(setmeal_count);//预约数量
                row.getCell(6).setCellValue(proportion.doubleValue());// 占比
            }

            //通过输出流进行文件下载
            ServletOutputStream out = res.getOutputStream();
            res.setContentType("application/vnd.ms-excel");
            res.setHeader("content-Disposition", "attachment;filename=report.xlsx");
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Code.SAVE_ERR, Msg.GET_BUSINESS_REPORT_FAIL);
        }
    }
}
