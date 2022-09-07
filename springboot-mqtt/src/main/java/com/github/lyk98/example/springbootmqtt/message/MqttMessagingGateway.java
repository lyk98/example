package com.github.lyk98.example.springbootmqtt.message;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * mqtt 通信网关
 *
 * @author lyk
 * @date 2022/9/7 9:43
 */
@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttMessagingGateway {

    void sendToMqtt(String data);

    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);

}