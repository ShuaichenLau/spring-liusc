package com.liusc.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class QueueConfig {

    @Value("${queue}")
    public String queue;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queue);
    }
}
