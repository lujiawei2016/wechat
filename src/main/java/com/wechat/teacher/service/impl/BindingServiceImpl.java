package com.wechat.teacher.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.teacher.dao.mapping.BindingDao;
import com.wechat.teacher.po.Student;
import com.wechat.teacher.service.BindingService;

/**
 * 
 * @Description  绑定实现类service
 * @author       lujiawei
 * @date         2017年2月9日 上午10:06:22
 * @version      V1.0
 *
 */
@Service
@Transactional
public class BindingServiceImpl implements BindingService {
	
	@Autowired
	private BindingDao bindingDao;

	/**
	 * 
	 * @Description  根据微信号查找学生
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:00:52
	 * @param weixin
	 * @return
	 */
	@Override
	public List<Student> findStudentByWeixin(String weixin) {
		List<Student> studentList = bindingDao.findStudentByWeixin(weixin);
		return studentList;
	}

	/**
	 * 
	 * @Description  根据手机号查找学生
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:01:02
	 * @param phone
	 * @return
	 */
	@Override
	public List<Student> findStudentByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @Description  将微信和手机号码绑定
	 * @author       lujiawei
	 * @date         2017年2月9日 上午10:03:17
	 * @param weixin
	 * @param phone
	 * @return
	 */
	@Override
	public String bindWeixinPhone(String weixin, String phone) {
		if(StringUtils.isBlank(weixin)){
			//微信号为空
			return "1";
		}else if(StringUtils.isBlank(phone)){
			//电话号码为空
			return "2";
		}else{
			List<Student> studentList = findStudentByPhone(phone);
			if(studentList.size() == 0){
				//手机号码不存在
				return "3";
			}else{
				Student student = studentList.get(0);
				if(StringUtils.isBlank(student.getWeixin())){
					//可以绑定
					return "4";
				}else{
					//该学生已经被绑定
					return "5";
				}
			}
		}
	}

}
