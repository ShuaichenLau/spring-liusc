package com.liusc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liusc.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class MockController {

    @Value("${URL}")
    private String URL;
    @Value("${CLASS_ID}")
    private String classId;
    @Value("${user.number}")
    private String userNumber;
    @Value("${user.group}")
    private String userGroup;
    @Value("${user.type}")
    private String userType;
    @Value("${user.nameStr}")
    private String name;
    @Value("${user.actual_name}")
    private String userActualName;
    @Value("${user.avatar}")
    private String userAvatar;
    @Value("${user.status}")
    private String userStatus;
    @Value("${user.end_type}")
    private String userEndType;
    @Value("${user.version}")
    private String userVersion;


    private User user;


    @RequestMapping("/user")
    public JSONObject User() {

        user = new User();
        user.setNumber(userNumber);
        user.setGroup(userGroup);
        user.setType(userType);
        user.setName(name);
        user.setActual_name(userActualName);
        user.setAvatar(userAvatar);
        user.setStatus(userStatus);
        user.setEnd_type(userEndType);
        user.setVersion(userVersion);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        return jsonObject;
    }

}
