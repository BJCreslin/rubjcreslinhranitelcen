package ru.bjcreslin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ReadXLSController {
    //todo сделать загрузку файла через нет
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public
    String provideUploadInfo() {
        return "uploadForm";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
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
