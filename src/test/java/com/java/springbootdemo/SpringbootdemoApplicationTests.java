package com.java.springbootdemo;

import com.github.pagehelper.PageHelper;
import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.service.UserService;
import com.java.utils.RedisUtil;
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
	private UserService service;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisUtil redisUtil;
	@Test
	public void contextLoads() {
		com.github.pagehelper.Page page=PageHelper.startPage(1,10);
		List<User>list=userDao.findAll();
        System.out.println(redisUtil.lSet("userList",list,20));
	}

}

