package com.liusc.customer;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.*;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Customer {

    private final static String QUEUE_NAME = "test_queue";


    public static void main(String[] args) {

        try {
            System.out.println(" Customer2 " + new Date().toString());
            // 1.获取连接
            Connection connection = MQConnectionUtils.newConnection();
            // 2.获取通道
            Channel channel = connection.createChannel();
            channel.basicQos(1); //保证只能分发1次 限制发送给同一个消费者 不得超过1条消息
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    String str = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费者获取消息2 " + str);
                }
            };

            channel.basicConsume(QUEUE_NAME,true,defaultConsumer);

        } catch (Exception e) {
            e.printStackTrace();


        }

    }

}
