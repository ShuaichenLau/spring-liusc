package com.liusc.producer;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ProducerDirect {

    private static final String EXCHANGE_NAME = "direct_exchage";

    public static void main(String[] args) {
        try {
            Connection connection = MQConnectionUtils.newConnection();
            Channel channel = connection.createChannel();
            // 绑定交换机 参数1交换机名称 参数2 exchange类型
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            String routingKey = "info";

            for (int i = 0; i < 10; i++) {
                String msg = i + " direct_exchage_msg " + routingKey + " " + new Date().toString();
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
                System.out.println(msg);
                Thread.sleep(1000);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
