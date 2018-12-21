package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.controller
 * @ClassName: IndesController
 * @Author: Administrator
 * @Description: ${description} 页面类
 * @Date: 2018/12/21 16:49
 * @Version: 1.0
 */
@Controller
public class IndexController {
	@RequestMapping(value = "login")
	public String login(){
		return "login";
	}
}
