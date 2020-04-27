package com.silent;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.silent.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 搭建Apollo 配置中心
 * 什么是分布式配置中心
 * @author liusc
 * 2020-4-16 01:55:43
 */
@Configuration
//@EnableAutoConfiguration
@EnableApolloConfig
@SpringBootApplication
//@EnableEurekaServer
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
