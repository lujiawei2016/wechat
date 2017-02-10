package com.wechat.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @description     学生controller
 * @author          lujiawei
 * @data            2017年2月9日 下午11:19:09
 * @version         v1.0
 */
@Controller
@RequestMapping("/studentController")
public class StudentController {

	/**
	 * 
	 * @description     列出所有学生
	 * @author          lujiawei
	 * @data            2017年2月9日 下午11:19:51
	 * @version         v1.0
	 * @return
	 */
	@RequestMapping("/listStudent")
	public String listStudent(){
		return "WEB-INF/jsp/background/student";
	}
}
