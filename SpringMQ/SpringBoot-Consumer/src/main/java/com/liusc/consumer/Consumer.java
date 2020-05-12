package com.liusc.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "${queue}")
    public void review(String msg){
        System.out.println("get " + msg);
    }
}
