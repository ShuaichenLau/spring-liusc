package com.liusc.topicModel;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ConsumerEmailDirect {

    private static final String QUEUE_NAME = "consumer_topic_email";
    private static final String EXCHANGE_NAME = "topic_exchange";


    public static void main(String[] args) {
        System.out.println("消费者邮箱启动 ConsumerEmail_topic " + new Date());

        try {
            Connection connection = MQConnectionUtils.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 4.消费者绑定交换机 参数1 队列 参数2交换机 参数3 routingKey
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "log.*");

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    String str = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费者邮箱启动 ConsumerEmail_topic " + " " + str);
                }
            };
            channel.basicConsume(QUEUE_NAME, true, defaultConsumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
