package com.java.controller;

import com.java.service.UserService;
import com.java.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.controller
 * @ClassName: UserController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/21 15:37
 * @Version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("userLogin")
	public String login(HttpServletRequest request){
		try {
			String userName=request.getParameter("name");
			String password=request.getParameter("pass");
			service.login(userName, password);
			return "index";
		} catch (Exception e) {
			LogUtil.getError(""+e);
			return "";
		}
	}
}
