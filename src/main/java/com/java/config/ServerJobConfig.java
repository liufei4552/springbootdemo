package com.java.config;


import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* 功能描述:
 * @param
* @return:
* @Author: liufei
* @Date: 2020/1/13 10:11
*/

@Data
@Configuration
@ConfigurationProperties(prefix = "xxl-job")
@ComponentScan(basePackages = "com.ultrapower.ctsmanageserver.common.jobhandler")
public class ServerJobConfig {
    private Logger logger = LoggerFactory.getLogger(ServerJobConfig.class);
    private String adminAddress;
    private String executorAppname;
    private String executorIp;
    private int executorPort;
    private String accessToken;
    private String executorLogpathogpath;
    private int executorLogretentiondays;

    //@Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddress);
        xxlJobSpringExecutor.setAppName(executorAppname);
        xxlJobSpringExecutor.setIp(executorIp);
        xxlJobSpringExecutor.setPort(executorPort);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(executorLogpathogpath);
        xxlJobSpringExecutor.setLogRetentionDays(executorLogretentiondays);
        return xxlJobSpringExecutor;
    }

    /**
     * 针对多网卡、容器内部署等情况，可借助 "spring-cloud-commons" 提供的 "InetUtils" 组件灵活定制注册IP；
     *
     *      1、引入依赖:
     *          <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-commons</artifactId>
     *             <version>${version}</version>
     *         </dependency>
     *
     *      2、配置文件，或者容器启动变量
     *          spring.cloud.inetutils.preferred-networks: 'xxx.xxx.xxx.'
     *
     *      3、获取IP
     *          String ip_ = inetUtils.findFirstNonLoopbackHostInfo().getIpAddress();
     */


}