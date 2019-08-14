package com.java.dao;

import com.java.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.dao
 * @ClassName: UserDao
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 14:39
 * @Version: 1.0
 */
@Repository("UserDao")
public interface UserDao {
    /**
     * @return java.util.List<com.java.bean.User>
     * @Author LiuFei
     * @Description 查询所用的用户信息
     * @Date 14:44 2018/12/21
     * @Param []
     **/
    public List<User> findAll();

    /**
     * @return int
     * @Author LiuFei
     * @Description 查询用户总数
     * @Date 14:45 2018/12/21
     * @Param []
     **/
    public int findCount();

    /**
     * @return int
     * @Author LiuFei
     * @Description 用户登录
     * @Date 16:07 2018/12/21
     * @Param [name, pass]
     **/
    public int login(String name, String pass);
}
