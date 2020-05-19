package com.liusc.producer;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Producer {

    private static final String QUEUE_NAME = "test_queue";


    public static void main(String[] args) {


        try {
            // 1.获取连接
            Connection connection = MQConnectionUtils.newConnection();
            // 2.创建通道
            Channel channel = connection.createChannel();
            // 3.创建队列声明
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicQos(1); // 保证只能分发1次 限制发送给同一个消费者 不得超过一条消息
            for (int i = 0; i < 10; i++) {
                String msg = "test_liusc8485 " + new Date().toString() + " " + i;
                System.out.println("生产者发送消息" + msg);
                // 4.发送消息
                channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
                Thread.sleep(1000);
            }
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
