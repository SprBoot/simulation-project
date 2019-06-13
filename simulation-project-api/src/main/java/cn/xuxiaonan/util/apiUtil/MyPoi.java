package cn.xuxiaonan.util.apiUtil;

import cn.xuxiaonan.enums.Character;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @program: api
 * @description: Excel工具类
 * @author: dinggc
 * @create: 2019-01-30 14:44
 **/
public class MyPoi {
    /**
     *  判断是否有计算公式
     */
    public static String getMyCellFormula(Cell cell){
//		初始值为空字符串
        String value = Character.NULLCHARACTER.getSymbolName();
        if (cell != null) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_FORMULA:
                    try {
                        value = String.valueOf(cell.getNumericCellValue());
                    } catch (Exception e) {
                        value = String.valueOf(cell.getRichStringCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    DecimalFormat decimalFormat = new DecimalFormat();
                    value = decimalFormat.format(cell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    value = String.valueOf(cell.getRichStringCellValue());
                    break;
            }
        }

        return value;
    }

    /**
     *  得到日期
     */
    public static Date getMyCellDate(Cell cell){
        Date date = null;

        String cellStr = String.valueOf(cell);
//		判断cell是否是null 或者 cellStr是否空字符串
        if(cell==null || Character.NULLCHARACTER.getSymbolName().equals(cellStr)){

        }else{
            try {
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
                //自定义的格式写法
                String []arr = cellStr.split(Character.SUBTRACT.getSymbolName());
                System.out.println(cellStr);
                date = cell.getDateCellValue();
            } catch (Exception e) {
                String dateStr = String.valueOf(cell);
                date = new Date(dateStr);
            }
            System.out.println(date);
        }

        return date;
    }
}
