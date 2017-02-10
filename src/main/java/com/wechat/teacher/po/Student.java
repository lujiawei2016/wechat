package com.wechat.teacher.po;

import java.util.Date;

/**
 * 
 * @description     学生表
 * @author          lujiawei
 * @data            2017年2月8日 下午10:32:41
 * @version         v1.0
 */
public class Student {

	private String studentId;                // 主键
	
	private String name;                  // 学生名
	
	private String phone;                 // 家长电话
	
	private String weixin;                // 家长微信
	
	private Date createTime;              // 创建时间

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
