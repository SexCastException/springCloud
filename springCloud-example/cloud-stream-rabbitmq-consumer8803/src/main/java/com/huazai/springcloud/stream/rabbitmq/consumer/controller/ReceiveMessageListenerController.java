package com.huazai.springcloud.stream.rabbitmq.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyh
 * @date 2020/8/24 20:27
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号：-----》接受消息：" + message.getPayload() + "\t port:" + serverPort);
    }
}
