package com.wechat.teacher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.teacher.po.User;
import com.wechat.teacher.service.UserService;

/**
 * 
 * @description     用户controller
 * @author          lujiawei
 * @data            2017年2月9日 下午10:10:36
 * @version         v1.0
 */
@Controller
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @description     登录
	 * @author          lujiawei
	 * @data            2017年2月9日 下午10:11:42
	 * @version         v1.0
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(String username,String password,HttpServletRequest request){
		User user = userService.login(username, password);
		if(user == null){
			//登录失败
			return "0";
		}else{
			//登录成功
			request.getSession().setAttribute("user", user);
			return "1";
		}
	}
}
