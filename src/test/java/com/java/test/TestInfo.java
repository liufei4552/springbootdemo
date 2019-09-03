package com.java.test;

import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.utils.JSONUtil;
import com.java.utils.RedisUtil;
import com.java.utils.SerializeUtil;
import com.java.utils.StringUtile;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @projectName: springbootdemo
 * @package: com.java.test
 * @className: Test
 * @author: liufei
 * @description: ${description}    功能描述
 * @date: 2019/8/30  16:29
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestInfo {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
//        List<User> userList = userDao.findAll();
//        redisUtil.set(SerializeUtil.serialize("userList"), SerializeUtil.serialize(userList), 28800);
        System.out.println("==========================================================================");
        byte[] bytes = redisUtil.get(SerializeUtil.serialize("userList"));
        List<User> userList1 = SerializeUtil.unserializeList(bytes);
        log.info("测试:" + userList1);
    }
}
