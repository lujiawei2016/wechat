package com.wechat.teacher.vo;

import com.wechat.teacher.po.Score;

/**
 * 
 * @Description  成绩vo
 * @author       lujiawei
 * @date         2017年2月13日 上午10:13:24
 * @version      V1.0
 *
 */
public class ScoreVo extends Score {

	private String studentName;         // 学生姓名

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
