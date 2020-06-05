package com.java.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: springbootdemo
 * @Package: com.java.interceptor
 * @ClassName: WebConfigurer
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/22 15:14
 * @Version: 1.0
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer{
	//把自定义拦截器注入到这里
	@Autowired
	private MyInterceptor myInterceptor;
	/**
	 * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("开始添加自定义的拦截器................");
		// addPathPatterns("/**") 表示拦截所有的请求，
		// excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
		//registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns( "/login","/user/userLogin","/register");
		System.out.println("添加自定义的拦截器完成..................");
	}
	/**
	 * 这个方法是用来配置静态资源的，比如html，js，css，等等
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
	}

	/**
	 * 该方法主要用于无业务逻辑的页面跳转
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login").setViewName("login");
			registry.addViewController("/index").setViewName("index");
	}
}
