package com.java.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Component
public class MyInterceptor implements HandlerInterceptor {
	/*private FunctionService functionService;

	public FunctionService getFunctionService() {
		return functionService;
	}
	@Resource
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}*/

	@Override
	public void afterCompletion(HttpServletRequest arg0,
								HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
						   Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取到当前路径
		String url = request.getRequestURI();
		String[] str=url.split("/");
		// 判断用户是否登录，在session中拿到当前登录用户
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		//获取当前请求的路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		//创建一个变量接收权限字符串
		/*List<Function>list=new ArrayList<>();
		if(!"".equals(uname)){
			DataSourceContextHolder.setDbType(DataSourceType.DATA1);
			 list=functionService.findfunbyname(uname);
		}
		List<String>list1=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			list1.add(list.get(i).getF_url());
		}*/
		//首先判断是否被登录
//		if (uname != null) {
			//判断是否有权限访问
//			String string=str[str.length-2]+"/"+str[str.length-1];
			/*if(list1.contains(string)==false){
				response.setHeader("function", "false");
				return false;
			}else {
			  return true;
			}*/
//		}
		//重定向到login.html
		//redirect(request, response,basePath);
		//System.out.println("您无权访问.........");
		return true;

	}

	//对于请求是ajax请求重定向问题的处理方法
	public void redirect(HttpServletRequest request, HttpServletResponse response,String basePath) throws IOException {
		//如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			String str=basePath+"/pages/login.jsp";
			//告诉ajax我重定向的路径
			response.setHeader("CONTENTPATH", str);
			//告诉ajax我是重定向
			response.setHeader("REDIRECT", "REDIRECT");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} /*else {
			response.sendRedirect(basePath + "/login");
		}*/
	}
}
