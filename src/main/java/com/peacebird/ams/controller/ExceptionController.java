package com.peacebird.ams.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @autor kevin.dai
 * @Date 2018/2/12
 */

@Controller
public class ExceptionController implements ErrorController{




    @GetMapping("/error")
    public String erroh(){
        return "404";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
