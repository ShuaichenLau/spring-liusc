package com.liusc.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutSmsConsumer {

    @RabbitHandler
    @RabbitListener(queues = "fanout_sms_queue")
    public void proess(String msg) {
        System.out.println("FanoutSmsConsumer " + msg);
    }
}
