package com.java.springbootdemo;

import com.github.pagehelper.PageHelper;
import com.java.annotation.RedisCache;
import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.repository.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootdemoApplicationTests {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        studentDao.delete("1");
    }

    @Test
    public void test() {
        com.github.pagehelper.Page page = PageHelper.startPage(1, 5);
        List<User> list = userDao.findAll();
    }
}

