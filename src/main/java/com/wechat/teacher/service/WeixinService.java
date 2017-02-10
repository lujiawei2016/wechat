package com.wechat.teacher.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wechat.teacher.message.resp.NewsMessage;
import com.wechat.teacher.message.resp.TextMessage;

/**
 * 
 * @description     微信service
 * @author          lujiawei
 * @data            2017年2月6日 下午10:20:57
 * @version         v1.0
 */
public interface WeixinService {

	/**
	 * 
	 * @description     解析微信发过来的请求
	 * @author          lujiawei
	 * @data            2017年2月6日 下午10:43:42
	 * @version         v1.0
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> parseXml(HttpServletRequest request) throws Exception;
	
	/**
	 * 
	 * @description     文本消息对象转换成xml
	 * @author          lujiawei
	 * @data            2017年2月6日 下午11:14:16
	 * @version         v1.0
	 * @param textMessage
	 * @return
	 */
	public String textMessageToXml(TextMessage textMessage);
	
	/**
	 * 
	 * @description     图文消息对象转换成xml
	 * @author          lujiawei
	 * @data            2017年2月6日 下午11:14:56
	 * @version         v1.0
	 * @param newsMessage
	 * @return
	 */
	public String newsMessageToXml(NewsMessage newsMessage);
}
