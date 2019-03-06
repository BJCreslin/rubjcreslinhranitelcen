package ru.bjcreslin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, Model model) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            System.out.println("Size:" + file.getSize());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<ItemModel> itemModels = XLSFileController.getList(multipartToFile(file));


            redirectAttributes.addFlashAttribute("prods", itemModels);


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
        File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                multipart.getOriginalFilename());
        multipart.transferTo(tmpFile);
        return tmpFile;
    }


//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
//                            @RequestParam("file") MultipartFile file) {
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream =
//                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
//                stream.write(bytes);
//                stream.close();
//                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
//            } catch (Exception e) {
//                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
//        }
//    }

}
