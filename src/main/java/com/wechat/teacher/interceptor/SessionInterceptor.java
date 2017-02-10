package com.wechat.teacher.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wechat.teacher.po.User;

/**
 * 
 * @description     登录过滤器
 * @author          lujiawei
 * @data            2017年2月9日 下午11:02:54
 * @version         v1.0
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 登录验证
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect("/wechat/login.jsp");
			return false;
		}else{
			return true;			
		}
	}

}
