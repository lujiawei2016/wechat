package com.wechat.teacher.service;

import java.util.List;

import com.wechat.teacher.po.Student;

/**
 * 
 * @Description  绑定service
 * @author       lujiawei
 * @date         2017年2月9日 上午10:00:45
 * @version      V1.0
 *
 */
public interface BindingService {

	/**
	 * 
	 * @Description  根据微信号查找学生
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:00:52
	 * @param weixin
	 * @return
	 */
	public List<Student> findStudentByWeixin(String weixin) throws Exception;
	
	/**
	 * 
	 * @Description  根据手机号查找学生
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:01:02
	 * @param phone
	 * @return
	 */
	public List<Student> findStudentByPhone(String phone) throws Exception;
	
	/**
	 * 
	 * @Description  判断手机号码是否能绑定
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:03:17
	 * @param weixin
	 * @param phone
	 * @return
	 */
	public String bindWeixinPhone(String weixin,String phone) throws Exception;
	
	/**
	 * 
	 * @description     将微信和学生绑定
	 * @author          lujiawei
	 * @data            2017年2月12日 上午12:33:41
	 * @version         v1.0
	 * @param weixin
	 * @param phone
	 * @return
	 */
	public String bindStudent(String weixin,String phone) throws Exception;
}
