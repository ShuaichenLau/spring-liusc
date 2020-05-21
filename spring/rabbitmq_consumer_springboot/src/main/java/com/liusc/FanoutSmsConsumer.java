package com.liusc;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutSmsConsumer {
	@RabbitListener(queues = "fanout_sms_queue")
	public void process(String msg) {
		System.out.println(msg);
	}
}
