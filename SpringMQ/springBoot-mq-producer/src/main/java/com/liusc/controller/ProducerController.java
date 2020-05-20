package com.liusc.controller;

import com.liusc.config.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private FanoutProducer fanoutProducer;

    @RequestMapping("/sendFanout")
    public String sendFanout(String queueName) {

//        for (int i = 0; i < 100; i++) {
//            fanoutProducer.send(queueName + System.currentTimeMillis());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        String msg = queueName + System.currentTimeMillis();
        fanoutProducer.send(msg);
        return "success " + msg;
    }


}
