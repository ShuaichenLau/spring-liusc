package com.silent.controller;

import com.silent.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/verifyUserNumber")
    public String verifyUserNumber(String number){
        boolean idNumber = userService.isIDNumber(number);

        if (idNumber){
            return number + " 是正确身份证";
        }else {
            return number + " 是错误身份证";
        }
    }

}
