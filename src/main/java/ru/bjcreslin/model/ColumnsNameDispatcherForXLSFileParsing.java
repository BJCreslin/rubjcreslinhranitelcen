package ru.bjcreslin.model;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static ru.bjcreslin.controller.xls.XLSSellController.*;

/**
 * Класс для формирования мапы для формирования
 */
@Data
public class ColumnsNameDispatcherForXLSFileParsing {

    private  Map<String, BiConsumer<ItemModel, HSSFCell>> stringFunctionMap;
//    public  Map<String, BiConsumer<ItemModel, HSSFCell>> getStringFunctionMap() {
//        return stringFunctionMap;
//    }

    public ColumnsNameDispatcherForXLSFileParsing() {
        stringFunctionMap = new HashMap<>();
        stringFunctionMap.put("название стройпарк", this::addNameStroypark);
        stringFunctionMap.put("адрес стройпарк", this::addAdressStroypark);
        stringFunctionMap.put("коэффициент стройпарк", this::addCoefficientStroypark);
        stringFunctionMap.put("код Водяной", this::addCodeWaterman);
        stringFunctionMap.put("группа", this::addGroupe);
        stringFunctionMap.put("", this::noneOperation);


    }

    void addNameStroypark(ItemModel itemModel, HSSFCell cell) {
        itemModel.setName(getStringFromCell(cell));
    }

    void addAdressStroypark(ItemModel itemModel, HSSFCell cell) {
        itemModel.setAdress(getStringFromCell(cell));
    }

    void addCoefficientStroypark(ItemModel itemModel, HSSFCell cell) {
        itemModel.setCoeff(getBigDecimalFromCell(cell));
    }

    void addCodeWaterman(ItemModel itemModel, HSSFCell cell) {
        itemModel.setCode(getLongFromCell(cell));
    }

    void addGroupe(ItemModel itemModel, HSSFCell cell) {
        itemModel.setName(getStringFromCell(cell));
    }

    public void noneOperation(ItemModel itemModel, HSSFCell cell){}
}
