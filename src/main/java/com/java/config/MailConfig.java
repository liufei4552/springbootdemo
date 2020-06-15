package com.java.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MailConfig
 * @Description
 * @Author liufei
 * @Date 2020/6/15 11:12
 * @Version V1.0
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConfig {
    private String host;
    private String from;
    private Integer port;
    private String user;
    private String pass;
}
