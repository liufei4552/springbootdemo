package com.java.test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.java.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @projectName: springbootdemo
 * @package: com.java.test
 * @className: TestLog
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/13  9:49
 * @version: 1.0
 */
public class TestLog {
    public static void main(String[] args) {
        Logger logger= LoggerFactory.getLogger(TestLog.class);
        logger.debug("hello world");

        //打印内部状态
//        LoggerContext lc=(LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
    }
}
