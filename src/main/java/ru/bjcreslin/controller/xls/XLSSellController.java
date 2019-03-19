package ru.bjcreslin.controller.xls;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class XLSSellController {
    /*
    Блок с методами, получающими данные из ячейки excell file
     */


    public static BigDecimal getBigDecimalFromCell(HSSFCell hssfCell) {
        DataFormatter fmtCode = new DataFormatter();
        return new BigDecimal(fmtCode.formatCellValue(hssfCell).
                replace(",", ".").replace(" ", "")).setScale(2, RoundingMode.HALF_UP);

    }

    public static long getLongFromCell(HSSFCell hssfCell) {
        try {
            DataFormatter fmtCode = new DataFormatter();
            return (long) (100 * Double.parseDouble(fmtCode.formatCellValue(hssfCell).
                    replace(",", ".").replace(" ", "")));
        } catch (Exception ex) {
            return 0;
        }
    }

    public static String getStringFromCell(HSSFCell hssfCell) {
        DataFormatter fmtCode = new DataFormatter();
        return fmtCode.formatCellValue(hssfCell);
    }
}
