package com.liusc.producer;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @author liusc
 * @date 2020年5月20日00:45:44
 */
public class ProducerFanout {

    private static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) {
        try {
            // 1.获取连接
            Connection connection = MQConnectionUtils.newConnection();
            // 2.获取通道
            Channel channel = connection.createChannel();
            // 3.绑定交换机 参数1交换机的名称 参数2交换机exchange类型
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            for (int i = 0; i < 10; i++) {
                String msg = i + " fanout_exchange_msg " + new Date().toString();
                System.out.println(msg);

                channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
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
