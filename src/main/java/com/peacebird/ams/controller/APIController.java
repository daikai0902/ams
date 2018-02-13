package com.peacebird.ams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor kevin.dai
 * @Date 2018/2/8
 */

@RestController
@RequestMapping("/api")
public class APIController {





    @GetMapping("/test")
    public String test(){
        return "test error";
    }











}
