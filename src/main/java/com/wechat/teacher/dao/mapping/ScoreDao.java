package com.wechat.teacher.dao.mapping;

import java.util.List;

import com.wechat.teacher.po.Score;

/**
 * 
 * @description     成绩dao
 * @author          lujiawei
 * @data            2017年2月12日 下午3:39:03
 * @version         v1.0
 */
public interface ScoreDao {

	/**
	 * 
	 * @description     查找学生成绩标题
	 * @author          lujiawei
	 * @data            2017年2月12日 下午4:57:25
	 * @version         v1.0
	 * @return
	 */
	public List<String> findScoreTitle();
	
	/**
	 * 
	 * @description     保存成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午4:57:35
	 * @version         v1.0
	 * @param score
	 */
	public void saveScore(Score score);
	
	/**
	 * 
	 * @description     根据标题查找学生
	 * @author          lujiawei
	 * @data            2017年2月12日 下午6:44:24
	 * @version         v1.0
	 * @param title
	 * @return
	 */
	public List<Score> findStudentByTitle(String title);

	/**
	 * 
	 * @description     根据标题删除成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午9:51:49
	 * @version         v1.0
	 * @param title
	 */
	public void deleteScoreByTitle(String title);
	
	/**
	 * 
	 * @description     根据学生id查找成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午11:11:18
	 * @version         v1.0
	 * @param studentId
	 * @return
	 */
	public List<Score> findScoreByStudentId(String studentId);
}
