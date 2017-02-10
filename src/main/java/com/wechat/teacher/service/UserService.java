package com.wechat.teacher.service;

import com.wechat.teacher.po.User;

/**
 * 
 * @description     用户service
 * @author          lujiawei
 * @data            2017年2月9日 下午10:32:38
 * @version         v1.0
 */
public interface UserService {

	/**
	 * 
	 * @description     登录
	 * @author          lujiawei
	 * @data            2017年2月9日 下午10:32:49
	 * @version         v1.0
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	
}
