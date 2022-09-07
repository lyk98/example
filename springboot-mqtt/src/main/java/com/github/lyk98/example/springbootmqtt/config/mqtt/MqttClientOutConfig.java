package com.github.lyk98.example.springbootmqtt.config.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.Objects;

/**
 * 配置出站消息通道及相关处理Bean
 *
 * @author lyk
 * @date 2022/9/6 17:23
 */
@Configuration
public class MqttClientOutConfig {
    @Autowired
    private MqttServerConfig mqttServerConfig;

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound(MqttPahoClientFactory mqttClientFactory) {
        String clientId = "mqtt-" + System.currentTimeMillis();
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory);
        messageHandler.setAsync(true);
        if (Objects.nonNull(mqttServerConfig.getPub())) {
            messageHandler.setDefaultTopic(mqttServerConfig.getPub());
        }
        return messageHandler;
    }

}
