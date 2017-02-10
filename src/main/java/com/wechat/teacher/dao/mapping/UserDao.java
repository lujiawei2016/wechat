package com.wechat.teacher.dao.mapping;

import java.util.List;

import com.wechat.teacher.po.User;

/**
 * 
 * @description     用户dao
 * @author          lujiawei
 * @data            2017年2月9日 下午10:35:36
 * @version         v1.0
 */
public interface UserDao {

	/**
	 * 
	 * @description     根据用户名查找用户
	 * @author          lujiawei
	 * @data            2017年2月9日 下午10:35:44
	 * @version         v1.0
	 * @param user
	 * @return
	 */
	public List<User> findUserByUsernameAndPassword(User user);
}
