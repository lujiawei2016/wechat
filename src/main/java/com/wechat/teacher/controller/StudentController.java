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

import com.wechat.teacher.po.Student;
import com.wechat.teacher.service.StudentService;
import com.wechat.teacher.utils.ImportExcelUtil;

/**
 * 
 * @description     学生controller
 * @author          lujiawei
 * @data            2017年2月9日 下午11:19:09
 * @version         v1.0
 */
@Controller
@RequestMapping("/studentController")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	/**
	 * 
	 * @description     列出所有学生
	 * @author          lujiawei
	 * @data            2017年2月9日 下午11:19:51
	 * @version         v1.0
	 * @return
	 */
	@RequestMapping("/listStudent")
	public String listStudent(ModelMap modelMap){
		List<Student> studentList;
		try {
			studentList = studentService.findAllStudent();
			modelMap.put("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "WEB-INF/jsp/background/student";
	}
	
	/**
	 * 
	 * @description     导入学生表
	 * @author          lujiawei
	 * @data            2017年2月10日 下午10:51:46
	 * @version         v1.0
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/importStudent")
	@ResponseBody
	public String importStudent(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
            Student student = new Student(String.valueOf(lo.get(0)), String.valueOf(lo.get(1)), String.valueOf(lo.get(2)));
            studentService.saveStudent(student);
        }  
          
        return "文件导入成功！";

    }  
}
