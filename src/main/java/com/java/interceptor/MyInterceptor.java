package com.java.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class MyInterceptor implements HandlerInterceptor {

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
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object arg2) throws Exception {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取到当前路径
		/*String url = request.getRequestURI();
		String[] str=url.split("/");
		System.out.println(url);
		if (url.indexOf("login") > 0) {
			return true;
		}*/
		// 判断用户是否登录，在session中拿到当前登录用户
		/*HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		if (uname != null) {
			return true;
		}*/
		return true;
		//重定向到login.html
		/*redirect(request, response);
		return false;*/

	}

	//对于请求是ajax请求重定向问题的处理方法
	public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前请求的路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		//如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			String str=basePath+"/login";
			//告诉ajax我重定向的路径
			response.setHeader("CONTENTPATH", str);
			//告诉ajax我是重定向
			response.setHeader("REDIRECT", "REDIRECT");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} else {
			response.sendRedirect(basePath + "/login");
		}
	}
}
