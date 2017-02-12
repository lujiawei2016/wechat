package com.wechat.teacher.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.teacher.dao.mapping.StudentDao;
import com.wechat.teacher.po.Student;
import com.wechat.teacher.service.StudentService;

/**
 * 
 * @description     学生实现类
 * @author          lujiawei
 * @data            2017年2月11日 下午1:34:56
 * @version         v1.0
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;

	/**
	 * 查找所有学生
	 */
	@Override
	public List<Student> findAllStudent() throws Exception {
		logger.info("列出所有学生");
		List<Student> studentList = studentDao.findAllStudent();
		return studentList;
	}

	/**
	 * 保存单个学生
	 */
	@Override
	public String saveStudent(Student student) throws Exception {
		Student studentData = studentDao.findStudentById(student.getStudentId());
		if(studentData == null){
			studentDao.saveStudent(student);
			logger.info("保存学生信息成功");
			return "1";
		}else{
			logger.error(student.getStudentId()+"该学号已经存在");
			throw new RuntimeException("该学号已经存在");
		}
	}

	/**
	 * 解绑微信
	 */
	@Override
	public String unbundling(String studentId) throws Exception {
		Student student = studentDao.findStudentById(studentId);
		if(student == null){
			//解绑失败
			logger.info(studentId+"解绑失败");
			return "1";
		}else{
			//解绑成功
			studentDao.setWeixinNull(studentId);
			logger.info(studentId+"解绑成功");
			return "2";
		}
	}

	/**
	 * 删除学生信息
	 */
	@Override
	public String deleteStudent(String studentId) throws Exception {
		Student student = studentDao.findStudentById(studentId);
		if(student == null){
			//删除失败
			logger.info(studentId+"删除成功");
			return "1";
		}else{
			//删除成功
			studentDao.deleteStudentById(studentId);
			logger.info(studentId+"删除成功");
			return "2";
		}
	}

	/**
	 * 根据微信查找学生信息
	 */
	@Override
	public List<Student> findStudentByWeixin(String weixin) throws Exception {
		return studentDao.findStudentByWeixin(weixin);
	}

}
