package ru.bjcreslin.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import ru.bjcreslin.entity.ItemEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLSFileController implements AppController {
    @Override
    public List<ItemEntity> getList() throws IOException {
        final String adressFile = "C:\\D\\xlsforsite\\Книга1.xls";

        HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(new File(adressFile)));
        HSSFSheet sheet = workbook.getSheetAt(0);

        List<ItemEntity> entityArrayList = new ArrayList<>();

        int controlCount = 0; //для счёта строчек и контроля "небесконечности"
        while (true) {
            // контроль "небесконечности" цикла
            if (controlCount > 1000) {
                break;
            }

            HSSFRow row = sheet.getRow(controlCount++);

            String name;
            DataFormatter fmtCode = new DataFormatter();
            try {
                name = fmtCode.formatCellValue(row.getCell(0));
            } catch (NullPointerException npe) {
                break;
            }
            if (name.isEmpty()) {
                break;
            }


            String adress = fmtCode.formatCellValue(row.getCell(1));

            Long price = getLongFromCell(row.getCell(2));
            Long discountPrice = getLongFromCell(row.getCell(3));
            Long code = getLongFromCell(row.getCell(4));
            String groupe = fmtCode.formatCellValue(row.getCell(5));

            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setName(name);
            itemEntity.setAdress(adress);
            itemEntity.setPrice(price);
            itemEntity.setDiscountPrice(discountPrice);
            itemEntity.setCode(code);
            itemEntity.setGroupe(groupe);

            entityArrayList.add(itemEntity);
        }

        return entityArrayList;
    }

    long getLongFromCell(HSSFCell hssfCell) {
        DataFormatter fmtCode = new DataFormatter();
        return (long) (100 * Double.parseDouble(fmtCode.formatCellValue(hssfCell).
                replace(",", ".").replace(" ", "")));
    }
}
