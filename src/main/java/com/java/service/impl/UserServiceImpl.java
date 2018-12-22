package com.java.service.impl;

import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.service.UserService;
import com.java.utils.LogUtil;
import com.java.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.service.impl
 * @ClassName: UserServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 14:40
 * @Version: 1.0
 */
@Service("UserServiceImpl")
@Transactional(rollbackFor =RuntimeException.class )
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public List<User> findAll() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			LogUtil.getError(""+e);
			return null;
		}
	}

	@Override
	public int findCount() {
		try {
			return dao.findCount();
		} catch (Exception e) {
			LogUtil.getError(""+e);
			return 0;
		}
	}

	@Override
	public int login(String name, String pass) {
		try {
			dao.login(name, pass);
			return Message.MESSAGE_SUCCESS;
		} catch (Exception e) {
			LogUtil.getError("登录失败:"+e);
			return Message.MESSAGE_UNKNOWN;
		}
	}
}
