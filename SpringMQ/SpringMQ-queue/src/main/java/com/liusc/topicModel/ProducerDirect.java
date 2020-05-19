package com.liusc.topicModel;

import com.liusc.utils.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ProducerDirect {

    private static final String EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] args) {
        try {
            Connection connection = MQConnectionUtils.newConnection();
            Channel channel = connection.createChannel();
            // 3.绑定的交换机 参数1交互机名称 参数2 exchange类型
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String routingKey = "log.info.error";

            for (int i = 0; i < 10; i++) {
                String msg = i + " topic_exchange_msg" + new Date() + " " + routingKey;
//            String msg = "topic_exchange_msg" + routingKey;
                System.out.println(msg);
                // 发送消息
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
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
