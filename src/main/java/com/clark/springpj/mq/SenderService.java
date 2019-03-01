package com.clark.springpj.mq;

import com.clark.springpj.config.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ClarkRao
 * @date 2019/2/28 15:03
 * @description:
 */
@Service
public class SenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 消息发送方法
     */
    public void send() {
        System.out.println("RYT 消息发送...");
        rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME, "你好，RYT");
        System.out.println("RYT 消息发送完毕");
    }

    /**
     * 消息发送方法
     */
    public void sendMessage(String message) {
        System.out.println("RYT 消息发送...");
        rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME, message);
        System.out.println("RYT 消息发送完毕");
    }
}