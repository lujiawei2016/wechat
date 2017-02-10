package com.wechat.teacher.dao.mapping;

import java.util.List;

import com.wechat.teacher.po.Student;

/**
 * 
 * @Description  绑定dao
 * @author       lujiawei
 * @date         2017年2月9日 上午10:10:47
 * @version      V1.0
 *
 */
public interface BindingDao {

	/**
	 * 
	 * @Description  根据微信号查找学生
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:00:52
	 * @param weixin
	 * @return
	 */
	public List<Student> findStudentByWeixin(String weixin);
	
	/**
	 * 
	 * @Description  根据手机号查找学生
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:01:02
	 * @param phone
	 * @return
	 */
	public List<Student> findStudentByPhone(String phone);
	
	/**
	 * 
	 * @Description  将微信和手机号码绑定
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:03:17
	 * @param weixin
	 * @param phone
	 * @return
	 */
	public String bindWeixinPhone(String weixin,String phone);
}
