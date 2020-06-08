package com.java.redission.config;

import com.java.redission.bean.RedissonConfig;
import com.java.redission.locker.DistributedLocker;
import com.java.redission.locker.impl.RedissonDistributedLocker;
import com.java.redission.util.RedissLockUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson+springboot 自动配置类
 * @author ko
 *
 */
@Configuration
@ConditionalOnClass(Config.class)
public class RedissonAutoConfiguration {

    @Autowired
    private RedissonConfig redssionProperties;

    /**
     * 哨兵模式自动装配
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "redisson", name = "sentinel" ,havingValue ="true")
    RedissonClient redissonSentinel() {
        System.out.println("--------------------------->redissonSentinel");
        System.out.println(redssionProperties.toString());
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(redssionProperties.getSentinelAddresses())
                .setMasterName(redssionProperties.getMasterName())
                .setTimeout(redssionProperties.getTimeout())
                .setMasterConnectionPoolSize(redssionProperties.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redssionProperties.getSlaveConnectionPoolSize());
        
    	if(redssionProperties.getPassword() != null && !"".equals(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        return Redisson.create(config);
    }

    /**
     * 单机模式自动装配
     * @return
     */
     @Bean
     @ConditionalOnProperty(prefix = "redisson", name = "single", havingValue ="true")
    RedissonClient redissonSingle() {
         System.out.println("--------------------------->redissonSingle");
         System.out.println(redssionProperties.toString());

         Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redssionProperties.getAddress())
                .setTimeout(redssionProperties.getTimeout())
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());
        
        if(redssionProperties.getPassword() != null && !"".equals(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }

        return Redisson.create(config);
    }

    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     * @return
     */
    @Bean
    DistributedLocker distributedLocker(@Qualifier("redissonSingle") RedissonClient redissonClient) {
    	RedissonDistributedLocker locker = new RedissonDistributedLocker();
        locker.setRedissonClient(redissonClient);
        RedissLockUtil.setLocker(locker);
        return locker;
    }

}