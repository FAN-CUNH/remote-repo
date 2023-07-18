package com.fch.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.utils
 * @ClassName POIUtil
 * @Description POI excel文件上传/下载
 * @Author Fan-CUNH
 * @Date 2023/7/14 10:11
 * @Version 1.0
 */
public class POIUtil {

    /**
     * 两种EXCEL文件后缀
     */
    private final static String XLS = "xls";
    private final static String XLSX = "xlsx";
    /**
     * 格式化日期
     */
    private final static String DATE_FORMAT = "yyyy/MM/dd";

    /**
     * @param file excel文件
     * @return 返回excel文件行内容的集合
     */
    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        // 文件检查
        checkFile(file);

        // 获取工作簿对象
        Workbook excel = getWorkBook(file);

        // 创建一个集合，把每一行作为一个数组，所有行作为一个集合返回
        ArrayList<String[]> list = new ArrayList<>(16);

        // 循环迭代每一个sheet表
        if (excel != null) {
            for (int sheetNum = 0; sheetNum < excel.getNumberOfSheets(); sheetNum++) {
                // 获取当前sheet表
                Sheet sheet = excel.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                // 获取当前sheet页的开始行 （有数据的第一行， 行号默认从0开始）
                int firstRowNum = sheet.getFirstRowNum();
                // 获取当前sheet页的结束行 （有数据的最后一行）
                int lastRowNum = sheet.getLastRowNum();
                // 循环除去第一行的所有行 （略过标题行）
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    // 获取当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }

                    // 获取当前行开始列
                    int firstCellNum = row.getFirstCellNum();
                    // 获取当前行结束列
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    // 动态的创建数组，根据当前行的列数声明数组长度
                    String[] cells = new String[lastCellNum];
                    // 循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        // 获取单元格对象
                        Cell cell = row.getCell(cellNum);
                        // 获取单元格的值，并设置到数组中
                        cells[cellNum] = getCellValue(cell);
                    }
                    // 将单元格数组存入行中
                    list.add(cells);
                }
            }
            excel.close();
        }
        return list;
    }

    /**
     * @param cell 单元格对象
     * @return 返回单元格中的内容
     */
    private static String getCellValue(Cell cell) {
        // 单元格的内容
        String cellValue = "";

        if (cell == null) {
            return cellValue;
        }

        // 如果单元格内容为日期类型，需要特殊处理
        String dataFormatString = cell.getCellStyle().getDataFormatString();
        if ("m/d/yy".equals(dataFormatString)) {
            cellValue = new SimpleDateFormat(DATE_FORMAT).format(cell.getDateCellValue());
            return cellValue;
        }

        // 把数字当成字符串读取，避免出现1 -> 1.0的情况
        if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            cell.setCellType(CellType.STRING);
        }

        // 判断数据的类型
        switch (cell.getCellTypeEnum()) {
            case NUMERIC: // 数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING: // 字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN: // 布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA: // 公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK: // 空值
                cellValue = "";
                break;
            case ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


    /**
     * @param file 文件对象
     * @return 返回工作簿对象
     */
    private static Workbook getWorkBook(MultipartFile file) {
        // 获取文件名
        String filename = file.getOriginalFilename();

        // 声明一个工作簿对象
        Workbook excel = null;
        try (InputStream inputStream = file.getInputStream()) {
            // 根据文件的不同后缀获取不同文件实体对象
            if (filename != null && filename.endsWith(XLS)) {
                excel = new HSSFWorkbook(inputStream);
            } else if (filename != null && filename.endsWith(XLSX)) {
                excel = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excel;
    }

    /**
     * 校验文件是否合法，即是否符合本项目的需求
     *
     * @param file 文件
     */
    private static void checkFile(MultipartFile file) throws IOException {
        // 判断文件是否存在
        if (file == null) {
            throw new FileNotFoundException("文件不存在！");
        }

        // 判断文件是否是Excel
        if (!file.getOriginalFilename().endsWith(XLS) && !file.getOriginalFilename().endsWith(XLSX)) {
            throw new IOException("不是Excel文件！");
        }
    }
}
