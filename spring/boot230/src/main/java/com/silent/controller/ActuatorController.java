package com.silent.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class ActuatorController {


    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/info")
    public String info(){
        return applicationName;
    }

}
