package com.wechat.teacher.service;

import java.util.List;

import com.wechat.teacher.po.Score;

/**
 * 
 * @description     学生service
 * @author          lujiawei
 * @data            2017年2月12日 下午3:48:26
 * @version         v1.0
 */
public interface ScoreService {

	/**
	 * 
	 * @description     查找成绩标题
	 * @author          lujiawei
	 * @data            2017年2月12日 下午3:48:55
	 * @version         v1.0
	 * @return
	 */
	public List<String> findScoreTitle();
	
	/**
	 * 
	 * @description     保存学生成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午5:01:03
	 * @version         v1.0
	 * @param studentId
	 * @param title
	 * @param china
	 * @param math
	 * @param english
	 * @param growthIntegral
	 * @param active
	 * @param leader
	 */
	public void saveScore(String studentId,String title,String china,
			String math,String english,String growthIntegral,
			String active,String leader);
	
	/**
	 * 
	 * @description     根据标题查找学生
	 * @author          lujiawei
	 * @data            2017年2月12日 下午6:43:09
	 * @version         v1.0
	 * @param title
	 * @return
	 */
	public List<Score> findStudentByTitle(String title);
	
	/**
	 * 
	 * @description     根据标题删除成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午9:42:34
	 * @version         v1.0
	 * @param title
	 * @return
	 */
	public String deleteScoreByTitle(String title);
	
	/**
	 * 
	 * @description     根据学生id查找成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午11:13:28
	 * @version         v1.0
	 * @param studentId
	 * @return
	 */
	public List<Score> findScoreByStudentId(String studentId);
}
