package com.clark.springpj.mq;

import com.clark.springpj.config.RabbitMqConfig;
import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author ClarkRao
 * @date 2019/2/28 14:11
 * @description: 消息接受者
 */
@Component
public class Receiver {


    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("消息接受成功:");
        System.out.println("Received <" + message + ">");
    }

}
