package ru.bjcreslin.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import ru.bjcreslin.controller.xls.XLSSellController;
import ru.bjcreslin.model.ItemModel;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.ROUND_CEILING;

public class XLSFileController {

    /**
     * Чтение данных из файла XLS
     *
     * @param file
     * @return
     * @throws IOException
     */

    public static List<ItemModel> getList(File file) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file));
        HSSFSheet sheet = workbook.getSheetAt(0);
        List<String> listColumnsNames=getColumnsNames(sheet);


        List<ItemModel> itemModelArrayList = new ArrayList<>();



        int controlCount = 1; //для счёта строчек и контроля "небесконечности" в 0 строчке названия столбцов
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

            ItemModel itemModel = new ItemModel();
            itemModel.setName(name);
            itemModel.setAdress(adress);
            itemModel.setPrice(price);
            itemModel.setDiscountPrice(discountPrice);
            itemModel.setCode(code / 100);
            itemModel.setGroupe(groupe);

            itemModelArrayList.add(itemModel);
        }

        return itemModelArrayList;
    }

    /**
     * @param sheet
     * @return List с названием столбцов
     */
    private static List<String> getColumnsNames(HSSFSheet sheet) {
        List<String> listColumnsNames = new ArrayList<>();
        //todo сделать метод

        HSSFRow rowWithColumnsNames = sheet.getRow(0);
        int i = 0;
        while (true) {
            String tempString = XLSSellController.getStringFromCell(rowWithColumnsNames.getCell(i++));
            if (tempString.isEmpty()) {
                break;
            }
            listColumnsNames.add(tempString);
        }
        return listColumnsNames;
    }








}
