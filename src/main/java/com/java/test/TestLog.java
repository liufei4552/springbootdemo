package com.java.test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.java.utils.JSONUtil;
import com.java.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
        List<String>list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        System.out.println(JSONUtil.toJSONString(list));
    }
}
