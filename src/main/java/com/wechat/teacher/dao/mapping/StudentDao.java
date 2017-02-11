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
}
