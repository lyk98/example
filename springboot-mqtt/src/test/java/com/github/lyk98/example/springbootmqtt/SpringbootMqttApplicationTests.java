package com.github.lyk98.example.springbootmqtt;

import com.github.lyk98.example.springbootmqtt.message.MqttMessagingGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMqttApplicationTests {

    @Autowired
    private MqttMessagingGateway mqttMessagingGateway;

    @Test
    void contextLoads() {
        mqttMessagingGateway.sendToMqtt("123");
    }

}
