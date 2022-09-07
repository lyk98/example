package com.github.lyk98.example.springbootmqtt.config.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MQTT 服务器相关配置
 *
 * @author lyk
 * @date 2022/9/6 17:13
 */
@Component
@ConfigurationProperties(prefix = "mqtt")
public class MqttServerConfig {
    /**
     * mqtt 服务器地址
     */
    private String host;

    /**
     * mqtt 用户名
     */
    private String username;

    /**
     * mqtt 密码
     */
    private String password;

    /**
     * 订阅的主题
     */
    private String[] sub;

    /**
     * 默认发布主题
     */
    private String pub;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getSub() {
        return sub;
    }

    public void setSub(String[] sub) {
        this.sub = sub;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }
}
