package com.java.bean;

import java.io.Serializable;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.bean
 * @ClassName: User
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 14:33
 * @Version: 1.0
 */
public class User implements Serializable{
	/**
	 * 索引
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 生日
	 */
	private String birth;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 邮件
	 */
	private String email;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 注册时间
	 */
	private String regTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public User(int id, String username, String password, String birth, String gender, String email, String status, String regTime) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.status = status;
		this.regTime = regTime;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", birth='" + birth + '\'' +
				", gender='" + gender + '\'' +
				", email='" + email + '\'' +
				", status='" + status + '\'' +
				", regTime='" + regTime + '\'' +
				'}';
	}
}
