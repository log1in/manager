package com.xyha.manager.student_manager.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    // 定义范型，这样就能传对应的实体类来封装excel数据
    private T t;

    public ExcelUtils(T t) {
        this.t = t;
    }
    public List<Map<String,String>> AnalysisExcel(InputStream is, String fileName) throws IOException {

        List<Map<String,String>> list = new ArrayList<>();
        Workbook workbook = createWorkbookByExcelType(is, fileName); // 创建工作簿

        Sheet sheet = workbook.getSheetAt(0);
        Row row = null;

        // 获取最大行数
        int maxRowNum = sheet.getLastRowNum();

        // 获取第一行
        row = sheet.getRow(0);

        // 获取最大列数
        int maxColNum = row.getLastCellNum();

        List<String> arrayList = new ArrayList<>();

        Field[] declaredFields = t.getClass().getDeclaredFields();

        for (int i=1;i<declaredFields.length;i++){
            String name = declaredFields[i].getName();
            arrayList.add(name);
        }

        // 循环遍历excel表格，把每条数据封装成 map集合，再放入list集合中
        for (int i = 1; i <= maxRowNum; i++) {
            Map<String, String> map = new HashMap<>();

            row = sheet.getRow(i);

            if (row != null){
                for (int j = 0; j < maxColNum; j++) {
                    String cellData = (String)getCellFormatValue(row.getCell(j));
                    map.put(arrayList.get(j), cellData); // map 封装
                }
                list.add(map); // map存入list
            }
        }
        LOGGER.info(list.toString());
        return list;
    }

    public static Object getCellFormatValue(Cell cell){
        Object cellValue;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf((int)cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

    public static Workbook createWorkbookByExcelType(InputStream inputStream,String fileName){
        if(fileName != null){
            String extString = fileName.substring(fileName.lastIndexOf("."));
            InputStream is = null;
            try {
                is = inputStream;
                if(".xls".equals(extString)){
                    return  new HSSFWorkbook(is); // 2003版本 .xls
                }else if(".xlsx".equals(extString)){
                    return new XSSFWorkbook(is); // 2007版本 .xlsx
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
