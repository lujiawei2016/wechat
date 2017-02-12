package com.wechat.teacher.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.teacher.po.Score;
import com.wechat.teacher.po.Student;
import com.wechat.teacher.service.ScoreService;
import com.wechat.teacher.service.StudentService;

/**
 * 
 * @description     家长controller
 * @author          lujiawei
 * @data            2017年2月12日 下午10:05:38
 * @version         v1.0
 */
@Controller
@RequestMapping("/parentsController")
public class ParentsController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ScoreService scoreService;
	
	/**
	 * 
	 * @description     根据微信查询学生成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午10:06:51
	 * @version         v1.0
	 * @param weixin
	 * @return
	 */
	@RequestMapping("/findStudentByWeixin")
	public String findStudentByWeixin(String weixin,ModelMap modelMap){
		try {
			if(!StringUtils.isBlank(weixin)){
				List<Student> studentList = studentService.findStudentByWeixin(weixin);
				if(studentList != null && studentList.size() != 0){
					List<Score> scoreList = scoreService.findScoreByStudentId(studentList.get(0).getStudentId());
					modelMap.put("studentName", studentList.get(0).getName());
					modelMap.put("scoreList", scoreList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "WEB-INF/jsp/front/studentScore";
	}
}
