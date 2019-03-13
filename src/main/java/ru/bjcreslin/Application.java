package ru.bjcreslin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {


    public static void main(String[] args) throws IOException {
         SpringApplication.run(Application.class);

//        AppController controller = new XLSFileController();
//        AppView view = new ConsoleViewver();
//        List<ItemModel> itemEntityArrayList = controller.getList();
//
//
//
//        WatermanSiteParserController watermanSiteParserController =
//                new WatermanSiteParserController();
//        watermanSiteParserController.addPriceNameInList(itemEntityArrayList);
//
//        view.show(itemEntityArrayList);
    }

}
