package ru.bjcreslin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bjcreslin.model.ItemModel;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ReadXLSController {
    //todo сделать загрузку файла через нет
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String provideUploadInfo() {
        return "uploadForm";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) {


        try {

            List<ItemModel> itemModels = XLSFileController.getList(multipartToFile(file));
            WatermanSiteParserController.addPriceNameInList(itemModels);


            model.addAttribute("prods", itemModels);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadStatus";
    }


    /**
     * @param multipart
     * @return File
     * @throws IllegalStateException
     * @throws IOException           преобразует MultipartFile to File
     */
    private static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File file = File.createTempFile("tmp", null);
        multipart.transferTo(file);
        file.deleteOnExit();
        return file;
    }


}
