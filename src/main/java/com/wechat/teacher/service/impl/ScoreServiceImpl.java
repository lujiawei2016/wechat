package com.wechat.teacher.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.teacher.dao.mapping.ScoreDao;
import com.wechat.teacher.po.Score;
import com.wechat.teacher.service.ScoreService;

/**
 * 
 * @description     学生成绩实现类
 * @author          lujiawei
 * @data            2017年2月12日 下午3:49:38
 * @version         v1.0
 */
@Transactional
@Service
public class ScoreServiceImpl implements ScoreService {
	
	private static final Logger logger = Logger.getLogger(ScoreServiceImpl.class);
	
	@Autowired
	private ScoreDao scoreDao;

	/**
	 * 查找学生标题
	 */
	@Override
	public List<String> findScoreTitle() {
		List<String> titleList = scoreDao.findScoreTitle();
		return titleList;
	}

	/**
	 * 保存学生信息
	 */
	@Override
	public void saveScore(String studentId, String title, String china, String math, String english,
			String growthIntegral, String active, String leader) {
		Score score = new Score(studentId, title, china, math, english, growthIntegral, active, leader);
		scoreDao.saveScore(score);
		logger.info("保存学号为"+studentId+"的学生信息成功");
	}

	/**
	 * 根据标题查找学生
	 */
	@Override
	public List<Score> findStudentByTitle(String title) {
		return scoreDao.findStudentByTitle(title);
	}

	/**
	 * 根据标题删除成绩
	 */
	@Override
	public String deleteScoreByTitle(String title) {
		scoreDao.deleteScoreByTitle(title);
		return "1";
	}

	/**
	 * 根据学生id查找成绩
	 */
	@Override
	public List<Score> findScoreByStudentId(String studentId) {
		return scoreDao.findScoreByStudentId(studentId);
	}

}
