package com.liusc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class FanoutConfig {

    // 邮件队列
    private String FANOUT_EMAIL_QUEUE = "fanout_email_queue";

    // 短信队列
    private String FANOUT_SMS_QUEUE = "fanout_sms_queue";

    // 交换机
    private String EXCHANGE_NAME = "fanoutExchange";

    @Bean
    public Queue fanOutEmailQueue(){
        return new Queue(FANOUT_EMAIL_QUEUE);
    }

    @Bean
    public Queue fanOutSmsQueue(){
        return new Queue(FANOUT_SMS_QUEUE);
    }

    //定义交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME);
    }

    //队列与交换机绑定邮件队列
    @Bean
    public Binding bindingExchangeEmail(Queue fanOutEmailQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanOutEmailQueue).to(fanoutExchange);
    }

    //4.队列与交换机绑定短信队列
    @Bean
    public Binding bindingExchangeSms(Queue fanOutSmsQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanOutSmsQueue).to(fanoutExchange);
    }
}
