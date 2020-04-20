package com.silent;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

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
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
