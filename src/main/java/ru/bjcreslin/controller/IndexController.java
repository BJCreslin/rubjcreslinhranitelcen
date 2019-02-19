package ru.bjcreslin.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController

@RequestMapping("")
public class IndexController {

    private String action(HttpServletRequest httpServletReques,
                          HttpServletResponse response) {
return null;
    }
}
