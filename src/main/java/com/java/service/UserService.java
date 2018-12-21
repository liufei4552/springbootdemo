package com.java.service;

import com.java.bean.User;

import java.util.List;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.service
 * @ClassName: UserService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 14:40
 * @Version: 1.0
 */
public interface UserService {
	/**
	 * @Author LiuFei
	 * @Description 查询所用的用户信息
	 * @Date 14:44 2018/12/21
	 * @Param []
	 * @return java.util.List<com.java.bean.User>
	 **/
	public List<User> findAll();
	/**
	 * @Author LiuFei
	 * @Description  查询用户总数
	 * @Date 14:45 2018/12/21
	 * @Param []
	 * @return int
	 **/
	public int findCount();
	/**
	 * @Author LiuFei
	 * @Description 用户登录
	 * @Date 16:07 2018/12/21
	 * @Param [name, pass]
	 * @return int
	 **/
	public int login(String name,String pass);
}
