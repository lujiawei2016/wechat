package com.wechat.teacher.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wechat.teacher.po.Score;
import com.wechat.teacher.service.ScoreService;
import com.wechat.teacher.utils.FileOperateUtil;
import com.wechat.teacher.utils.ImportExcelUtil;
import com.wechat.teacher.vo.ScoreVo;

/**
 * 
 * @description     成绩controller
 * @author          lujiawei
 * @data            2017年2月12日 下午3:28:54
 * @version         v1.0
 */
@Controller
@RequestMapping("/scoreController")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;

	/**
	 * 
	 * @description     查找出学生成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午3:30:16
	 * @version         v1.0
	 * @return
	 */
	@RequestMapping("/listScoreTitle")
	public String listScoreTitle(ModelMap modelMap){
		List<String> titleList = scoreService.findScoreTitle();
		modelMap.put("titleList", titleList);
		return "WEB-INF/jsp/background/score";
	}
	
	/**
	 * 
	 * @description     导入成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午4:41:30
	 * @version         v1.0
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/importScore")
	@ResponseBody
	public String importScore(HttpServletRequest request,HttpServletResponse response,String title) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
        
        InputStream in =null;  
        List<List<Object>> listob = null;  
        MultipartFile file = multipartRequest.getFile("file");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
          
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());  
          
        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
        for (int i = 0; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);
            scoreService.saveScore(String.valueOf(lo.get(0)),title, String.valueOf(lo.get(2)), String.valueOf(lo.get(3)), 
            		String.valueOf(lo.get(3)), String.valueOf(lo.get(4)), String.valueOf(lo.get(5)), 
            		String.valueOf(lo.get(6)));
        }
          
        return "文件导入成功！";

    }
	
	/**
	 * 
	 * @description     查看成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午6:25:04
	 * @version         v1.0
	 * @param title
	 * @return
	 */
	@RequestMapping("/lookScore")
	public String lookScore(String title,ModelMap modelMap) throws Exception{
		title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
		List<ScoreVo> scoreList = scoreService.findStudentByTitle(title);
		modelMap.put("scoreList", scoreList);
		return "WEB-INF/jsp/background/lookScore";
	}
	
	/**
	 * 
	 * @description     根据标题删除成绩
	 * @author          lujiawei
	 * @data            2017年2月12日 下午9:41:23
	 * @version         v1.0
	 * @param title
	 * @return
	 */
	@RequestMapping("/deleteByTitle")
	@ResponseBody
	public String deleteScoreByTitle(String title){
		String result = scoreService.deleteScoreByTitle(title);
		return result;
	}
	
	/**
	 * 
	 * @Description  下文成绩模板
	 * @author       lujiawei
	 * @date         2017年2月13日 上午9:42:37
	 */
	@RequestMapping("/downloadScoreTemplate")
	public void downloadScoreTemplate(HttpServletRequest request,HttpServletResponse response){
		FileOperateUtil.FilesDownload_stream(request, response, "/static/template/score.xlsx");
	}
}
