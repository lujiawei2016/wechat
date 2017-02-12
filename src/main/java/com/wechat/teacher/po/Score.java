package com.wechat.teacher.po;

import java.util.Date;

/**
 * 
 * @description     成绩表
 * @author          lujiawei
 * @data            2017年2月8日 下午11:10:34
 * @version         v1.0
 */
public class Score {

	private int scoreId;
	
	private String studentId;             // 学生id
	
	private String title;                 // 标题
	
	private String china;                 // 语文分数
	
	private String math;                  // 数学分数
	
	private String english;               // 英语分数
	
	private String growthIntegral;        // 成长积分
	
	private String active;                // 活跃度
	
	private String leader;                // 班干部分数
	
	private Date createTime;              // 创建时间

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChina() {
		return china;
	}

	public void setChina(String china) {
		this.china = china;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getGrowthIntegral() {
		return growthIntegral;
	}

	public void setGrowthIntegral(String growthIntegral) {
		this.growthIntegral = growthIntegral;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Score() {
		super();
	}

	public Score(String studentId, String title, String china, String math, String english, String growthIntegral,
			String active, String leader) {
		super();
		this.studentId = studentId;
		this.title = title;
		this.china = china;
		this.math = math;
		this.english = english;
		this.growthIntegral = growthIntegral;
		this.active = active;
		this.leader = leader;
	}
	
}
