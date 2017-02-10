package com.wechat.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.teacher.po.Student;
import com.wechat.teacher.service.BindingService;

/**
 * 
 * @description     绑定手机和
 * @author          lujiawei
 * @data            2017年2月8日 下午11:08:10
 * @version         v1.0
 */
@Controller
@RequestMapping("/bindingController")
public class BindingController {

	@Autowired
	private BindingService bindingService;

	/**
	 * 
	 * @Description  跳转到绑定页面，如果已经绑定则跳转到查询页
	 * @author       lujiawei
	 * @date         2017年2月9日 上午9:50:22
	 * @param weixin
	 * @return
	 */
	@RequestMapping("/jumpBinding")
	public String jumpBinding(String weixin,ModelMap modelMap){
		String url = "";
		List<Student> studentList = bindingService.findStudentByWeixin(weixin);
		if(studentList.size() != 0){
			//该微信号已经绑定了学生
			
		}else{
			//该微信号没有绑定学生
			modelMap.put("weixin", weixin);
			url = "WEB-INF/jsp/front/binding";
		}
		return url;
	}
	
	/**
	 * 
	 * @Description  对微信号和手机号进行绑定
	 * @author       lujiawei
	 * @date         2017年2月9日 下午5:21:24
	 * @param weixin
	 * @param phone
	 * @return
	 */
	@RequestMapping("/binding")
	public String binding(String weixin,String phone){
		
		return null;
	}
}
