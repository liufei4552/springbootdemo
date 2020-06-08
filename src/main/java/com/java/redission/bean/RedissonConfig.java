package com.java.redission.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redisson属性装配类
 * @author ko
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "redisson")
public class RedissonConfig {

    private int timeout = 3000;

    private String address;

    private String password;

    private int connectionPoolSize = 64;
    
    private int connectionMinimumIdleSize=10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;

}