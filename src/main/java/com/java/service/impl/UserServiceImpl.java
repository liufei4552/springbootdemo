package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.java.annotation.RedisCache;
import com.java.bean.User;
import com.java.dao.UserDao;
import com.java.service.UserService;
import com.java.utils.Message;
import com.java.utils.Page;
import com.java.utils.Result;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    @RedisCache(redisKey = "userList", expireTime = 20)
    public Result<Page<User>> findAll(Integer page, Integer pageSize) {
        Result<Page<User>> result = new Result();
        try {
            Page<User> userPage = new Page<>();
            com.github.pagehelper.Page pageHelper = PageHelper.startPage(page, pageSize);
            List<User> userList = dao.findAll();
            result.setCode("200");
            result.setMsg("成功");
            result.setSuccess(true);
            userPage.setItems(userList);
            userPage.setTotalNumber((int) pageHelper.getTotal());
            userPage.setPageSize(pageHelper.getPageSize());
            result.setData(userPage);
            return result;
        } catch (Exception e) {
            log.error("" + e);
            return null;
        }
    }

    @Override
    public int findCount() {
        try {
            return dao.findCount();
        } catch (Exception e) {
            log.error("" + e);
            return 0;
        }
    }

    @Override
    public int login(String name, String pass) {
        try {
            dao.login(name, pass);
            return Message.MESSAGE_SUCCESS;
        } catch (Exception e) {
            log.error("登录失败:" + e);
            return Message.MESSAGE_UNKNOWN;
        }
    }
}
