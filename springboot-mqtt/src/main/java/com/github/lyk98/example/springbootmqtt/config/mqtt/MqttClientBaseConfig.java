package com.github.lyk98.example.springbootmqtt.config.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

import java.util.Objects;

/**
 * 配置 mqtt 客户端 公用部分
 *
 * @author lyk
 * @date 2022/9/6 17:12
 */
@Configuration
public class MqttClientBaseConfig {
    @Autowired
    private MqttServerConfig mqttServerConfig;

    /**
     * mqtt 客户端工厂
     *
     * @return
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{mqttServerConfig.getHost()});
        if (Objects.nonNull(mqttServerConfig.getUsername())) {
            options.setUserName(mqttServerConfig.getUsername());
        }
        if (Objects.nonNull(mqttServerConfig.getPassword())) {
            options.setPassword(mqttServerConfig.getPassword().toCharArray());
        }
        factory.setConnectionOptions(options);
        return factory;
    }

}
