package com.github.lyk98.example.springbootmqtt;

import com.github.lyk98.example.springbootmqtt.message.MqttMessagingGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootMqttApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMqttApplication.class, args);
    }

}
