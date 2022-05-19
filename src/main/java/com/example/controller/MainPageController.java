package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.constants.PageNameConstants.MAIN_PAGE;

@RequiredArgsConstructor
@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage(Model model) {
        return MAIN_PAGE;
    }
}
