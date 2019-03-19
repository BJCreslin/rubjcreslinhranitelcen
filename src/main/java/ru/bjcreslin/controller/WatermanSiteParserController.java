package ru.bjcreslin.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.bjcreslin.model.ItemModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class WatermanSiteParserController {
    private static final String HTTP_WATERMAN_SEARCH_RESULT_Q = "http://xn--b1aeppdc1j.xn--p1ai/search/result?q=";

    public static void addPriceNameInList(List<ItemModel> itemModelList) {

        itemModelList.stream().forEach(
                p -> {
                    Document html = null;
                    try {
                        html = Jsoup.connect(HTTP_WATERMAN_SEARCH_RESULT_Q +
                                p.getCode().toString()).get();
                    } catch (IOException e) {

                    }

                    //добавляем название по коду
                    try {
                        p.setWaterName(html.getElementsByClass("hl--light").text());
                    } catch (NullPointerException npe) {

                    }

                    //добавляем цену по коду

                    try {
                        p.setWaterPrice(new BigDecimal(html.getElementsByClass("product-wrap").
                                first().text().replace(" ", "").
                                replace("\u20BDДобавитьвкорзину", "")));
                    } catch (NullPointerException npe) {

                    }
                });

    }

}
