package com.liusc.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutConfig {

	private String FANOUT_EMAIL_QUEUE = "fanout_email_queue";

	private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
	private String EXCHANGE_NAME = "fanoutExchange";

	@Bean
	public Queue fanOutEamilQueue() {
		return new Queue(FANOUT_EMAIL_QUEUE);
	}

	@Bean
	public Queue fanOutSmsQueue() {
		return new Queue(FANOUT_SMS_QUEUE);
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(EXCHANGE_NAME);
	}

	@Bean
	Binding bindingExchangeEamil(Queue fanOutEamilQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanOutEamilQueue).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeSms(Queue fanOutSmsQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanOutSmsQueue).to(fanoutExchange);
	}
}
