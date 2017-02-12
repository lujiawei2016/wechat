package com.wechat.teacher.dao.mapping;

import java.util.List;

import com.wechat.teacher.po.Student;

/**
 * 
 * @description     学生dao
 * @author          lujiawei
 * @data            2017年2月11日 下午1:19:53
 * @version         v1.0
 */
public interface StudentDao {

	/**
	 * 
	 * @description     根据id查找学生
	 * @author          lujiawei
	 * @data            2017年2月11日 下午1:20:28
	 * @version         v1.0
	 * @param studentId
	 * @return
	 */
	public Student findStudentById(String studentId);
	
	/**
	 * 
	 * @description     查找所有学生
	 * @author          lujiawei
	 * @data            2017年2月11日 下午1:30:57
	 * @version         v1.0
	 * @return
	 */
	public List<Student> findAllStudent();
	
	/**
	 * 
	 * @description     保存学生信息
	 * @author          lujiawei
	 * @data            2017年2月11日 下午1:20:52
	 * @version         v1.0
	 * @param student
	 */
	public void saveStudent(Student student);
	
	/**
	 * 
	 * @description     将微信设置为空
	 * @author          lujiawei
	 * @data            2017年2月11日 下午10:14:22
	 * @version         v1.0
	 * @param studentId
	 */
	public void setWeixinNull(String studentId);
	
	/**
	 * 
	 * @description     根据studentId删除学生
	 * @author          lujiawei
	 * @data            2017年2月11日 下午10:45:14
	 * @version         v1.0
	 * @param studentId
	 */
	public void deleteStudentById(String studentId);
	
	/**
	 * 
	 * @description     将微信和手机号绑定
	 * @author          lujiawei
	 * @data            2017年2月11日 下午11:02:30
	 * @version         v1.0
	 * @param weixin
	 * @param phone
	 */
	public void setWeixinPhone(Student student);
	
	/**
	 * 
	 * @description     根据微信查找学生
	 * @author          lujiawei
	 * @data            2017年2月12日 上午9:47:07
	 * @version         v1.0
	 * @param weixin
	 * @return
	 */
	public List<Student> findStudentByWeixin(String weixin);
	
	/**
	 * 
	 * @description     根据电话查找学生
	 * @author          lujiawei
	 * @data            2017年2月12日 上午9:50:05
	 * @version         v1.0
	 * @param phone
	 * @return
	 */
	public List<Student> findStudentByPhone(String phone);
}
