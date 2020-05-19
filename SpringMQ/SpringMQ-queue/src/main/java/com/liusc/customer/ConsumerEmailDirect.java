package com.liusc.customer;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ConsumerEmailDirect {

    private static final String QUEUE_NAME = "consumer_direct_email";
    private static final String EXCHAGE_NAME = "direct_exchage";

    public static void main(String[] args) {
        System.out.println("ConsumerEmailDirect 邮件消费者启动 " + new Date().toString());


        try {
            Connection connection = MQConnectionUtils.newConnection();
            Channel channel = connection.createChannel();
            // 消费者关联队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 4.消费者绑定交换机 参数1 队列 参数2交换机 参数3 routingKey
            channel.queueBind(QUEUE_NAME, EXCHAGE_NAME, "error");
            channel.queueBind(QUEUE_NAME, EXCHAGE_NAME, "info");

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    String msg = new String(body, StandardCharsets.UTF_8);
                    System.out.println("ConsumerEmailDirect 邮件消费者获取 " + msg);
                }
            };

            // 消费者监听队列小心
            channel.basicConsume(QUEUE_NAME,true,defaultConsumer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
