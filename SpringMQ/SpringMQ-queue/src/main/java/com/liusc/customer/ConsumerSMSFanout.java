package com.liusc.customer;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ConsumerSMSFanout {

    private static final String QUEUE_NAME = "consumerFanout_sms";
    private static final String EXCHANGE_NAME = "fanout_exchange";


    public static void main(String[] args) {
        try {
            System.out.println("ConsumerSMSFanout  消费者短信启动" + new Date().toString());


            Connection connection = MQConnectionUtils.newConnection();
            Channel channel = connection.createChannel();
            // 消费者 关联队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // 4.消费者绑定交换机 参数1 队列 参数2交换机 参数3 routingKey
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    String str = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费者短信 获取生产者消息" + str);

                }
            };

            channel.basicConsume(QUEUE_NAME, true, defaultConsumer);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
