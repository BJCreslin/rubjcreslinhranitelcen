package ru.bjcreslin.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.bjcreslin.model.ItemModel;

import java.io.IOException;
import java.util.List;

public class WatermanSiteParserController {
    private static final String HTTP_ВОДЯНОЙ_РФ_SEARCH_RESULT_Q = "http://xn--b1aeppdc1j.xn--p1ai/search/result?q=";

    public static void getListWithPrice(List<ItemModel> itemModelList) {

        itemModelList.stream().forEach(
                p -> {
                    Document html = null;
                    try {
                        html = Jsoup.connect(HTTP_ВОДЯНОЙ_РФ_SEARCH_RESULT_Q +
                                p.getCode().toString()).get();
                    } catch (IOException e) {
                    }
                    if (html.hasClass("hl--light"))
                        //добавляем название по коду
                        p.setWaterName(html.getElementsByClass("hl--light").first().text());

                        //добавляем цену по коду
                    p.setWaterPrice(Long.parseLong(html.getElementsByClass("product-wrap").
                            first().text().replace(" ", "").
                            replace("\u20BDДобавитьвкорзину", "")));
                });

    }

}
