package com.example.controller;

import com.example.constants.PageNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ErrorsController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public String handleNotFoundError() {
       log.info("Page was not found");
       return PageNameConstants.PAGE_NOT_FOUND;
    }
}
