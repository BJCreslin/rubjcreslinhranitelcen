package ru.bjcreslin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bjcreslin.controller.AppController;
import ru.bjcreslin.controller.WatermanSiteParserController;
import ru.bjcreslin.controller.XLSFileController;
import ru.bjcreslin.model.ItemModel;
import ru.bjcreslin.view.AppView;
import ru.bjcreslin.view.ConsoleViewver;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Application {


    public static void main(String[] args) throws IOException {
        // SpringApplication.run(Application.class);

        AppController controller = new XLSFileController();
        AppView view = new ConsoleViewver();
        List<ItemModel> itemEntityArrayList = controller.getList();

        view.show(itemEntityArrayList);

        WatermanSiteParserController watermanSiteParserController =
                new WatermanSiteParserController();
        watermanSiteParserController.addPriceNameInList(itemEntityArrayList);


    }

}
