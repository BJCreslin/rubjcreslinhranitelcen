package ru.bjcreslin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bjcreslin.Service.ItemServiceImpl;

@Controller

public class FromFileToBase {
    @Autowired
    ItemServiceImpl itemService;

    @GetMapping("/fromFileToBase")
    public String action(Model model) {
        itemService.saveAllStroyPark(ReadXLSController.getItemModels());
        model.addAttribute("name", "загружено в базу");
        return "index";
    }
}
