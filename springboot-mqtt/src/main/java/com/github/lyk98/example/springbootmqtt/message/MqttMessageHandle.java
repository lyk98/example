package com.github.lyk98.example.springbootmqtt.message;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * mqtt 消息处理器
 *
 * @author lyk
 * @date 2022/9/6 17:30
 */
@Component
public class MqttMessageHandle implements MessageHandler {

    @Override
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println(message.getHeaders());
        System.out.println(message.getPayload());
    }
}
