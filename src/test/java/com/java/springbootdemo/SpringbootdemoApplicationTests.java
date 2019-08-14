package com.java.springbootdemo;

import com.github.pagehelper.PageHelper;
import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.service.UserService;
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
	@Test
	public void contextLoads() {
		com.github.pagehelper.Page pageHelper = PageHelper.startPage(1, 3);
		List<User>list=userDao.findAll();
		log.info("测试:"+list);
	}

}

