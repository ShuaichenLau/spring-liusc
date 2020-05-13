package com.liusc.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class HelloWorldController {


    @RequestMapping("/")
    public String index(){
        return new Date().toString();
    }

}
