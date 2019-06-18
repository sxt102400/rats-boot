package com.rats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping("/hello")
    @ResponseBody
    private String hello(){
        return "hello";
    }
}
