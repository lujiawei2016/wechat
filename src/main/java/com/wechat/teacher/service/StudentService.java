package com.wechat.teacher.service;

import java.util.List;

import com.wechat.teacher.po.Student;

/**
 * 
 * @description     学生service
 * @author          lujiawei
 * @data            2017年2月11日 下午1:30:07
 * @version         v1.0
 */
public interface StudentService {

	/**
	 * 
	 * @description     查找全部学生
	 * @author          lujiawei
	 * @data            2017年2月11日 下午1:33:01
	 * @version         v1.0
	 * @return
	 */
	public List<Student> findAllStudent() throws Exception;
	
	/**
	 * 
	 * @description     保存学生
	 * @author          lujiawei
	 * @data            2017年2月11日 下午1:33:13
	 * @version         v1.0
	 * @param student
	 * @return
	 */
	public String saveStudent(Student student) throws Exception;
	
	/**
	 * 
	 * @description     解绑
	 * @author          lujiawei
	 * @data            2017年2月11日 下午10:18:39
	 * @version         v1.0
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public String unbundling(String studentId) throws Exception;
	
	/**
	 * 
	 * @description     删除学生信息
	 * @author          lujiawei
	 * @data            2017年2月11日 下午10:43:25
	 * @version         v1.0
	 * @return
	 * @throws Exception
	 */
	public String deleteStudent(String studentId) throws Exception;

	/**
	 * 
	 * @description     根据微信查找学生信息
	 * @author          lujiawei
	 * @data            2017年2月12日 下午11:03:32
	 * @version         v1.0
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudentByWeixin(String weixin) throws Exception;
	
}
