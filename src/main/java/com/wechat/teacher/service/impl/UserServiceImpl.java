package com.wechat.teacher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.teacher.dao.mapping.UserDao;
import com.wechat.teacher.po.User;
import com.wechat.teacher.service.UserService;

/**
 * 
 * @description     用户service实现类
 * @author          lujiawei
 * @data            2017年2月9日 下午10:33:11
 * @version         v1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/**
	 * 用户登录方法
	 */
	@Override
	public User login(String username, String password) {
		User user = new User(username, password);
		List<User> userList = userDao.findUserByUsernameAndPassword(user);
		if(userList.size() == 0){
			return null;
		}else{
			return userList.get(0);
		}
	}

	
}
