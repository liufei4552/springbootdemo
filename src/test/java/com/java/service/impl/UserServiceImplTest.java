package com.java.service.impl;

import com.java.bean.User;
import com.java.service.UserService;
import com.java.utils.JSONUtil;
import com.java.utils.Page;
import com.java.utils.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.service.impl
 * @ClassName: UserServiceImplTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 15:17
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	private UserService service;
	@Test
	public void findAll() {
		Result<Page<User>> result=service.findAll(1,10);
		System.out.println(JSONUtil.toJSONString(result));
	}

	@Test
	public void findCount() {
		System.out.println(service.findCount());
	}
}