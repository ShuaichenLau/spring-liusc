package com.silent.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author liusc
 */
@RestController
public class IndexController {

    @Value("${admin:default}")
    private String name;

    @Value("${applicationName:default}")
    private String applicationName;

    @RequestMapping("/")
    public String index() {
        return new Date().toString();
    }

    @RequestMapping("/name")
    public String getName() {
        return name;
    }

    @RequestMapping("/applicationName")
    public String getApplicationName() {
        long l = System.nanoTime();
        System.out.println(l);
        return applicationName;
    }


    public static void main(String[] args) {


        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(System.nanoTime()));
        System.out.println(new Date(System.currentTimeMillis()));
    }
}
