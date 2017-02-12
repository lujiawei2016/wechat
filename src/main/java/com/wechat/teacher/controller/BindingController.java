package com.wechat.teacher.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		List<Student> studentList = new ArrayList<Student>();
		try {
			studentList = bindingService.findStudentByWeixin(weixin);
			if(studentList.size() != 0){
				//该微信号已经绑定了学生
				
			}else{
				//该微信号没有绑定学生
				modelMap.put("weixin", weixin);
				url = "WEB-INF/jsp/front/binding";
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	@ResponseBody
	public String binding(String weixin,String phone){
		String result = "";
		try {
			result = bindingService.bindWeixinPhone(weixin, phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @description     绑定学生
	 * @author          lujiawei
	 * @data            2017年2月12日 上午12:38:57
	 * @version         v1.0
	 * @param weixin
	 * @param phone
	 * @return
	 */
	@RequestMapping("/bindStudent")
	@ResponseBody
	public String bindStudent(String weixin,String phone){
		String result = "";
		try {
			result = bindingService.bindStudent(weixin, phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @description     根据手机号查询名称
	 * @author          lujiawei
	 * @data            2017年2月12日 上午11:59:13
	 * @version         v1.0
	 * @param phone
	 * @return
	 */
	@RequestMapping("/findStudentNameByPhone")
	@ResponseBody
	public String findStudentNameByPhone(String phone) throws Exception{
		List<Student> studentList = new ArrayList<Student>();
		String name = "";
		studentList = bindingService.findStudentByPhone(phone);
		if(studentList != null && studentList.size() != 0){
			name = studentList.get(0).getName();
		}
		
		return "{\"name\":\""+name+"\"}";
	}
}
