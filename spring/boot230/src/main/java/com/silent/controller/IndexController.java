package com.silent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return new Date().toString();
    }
}
