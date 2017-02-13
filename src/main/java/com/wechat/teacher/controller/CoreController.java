package com.wechat.teacher.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.teacher.message.resp.TextMessage;
import com.wechat.teacher.service.WeixinService;
import com.wechat.teacher.utils.SignUtil;

/**
 * 
 * @description     微信核心类
 * @author          lujiawei
 * @data            2017年1月31日 下午4:29:41
 * @version         v1.0
 */
@Controller
@RequestMapping("/coreController")
public class CoreController {
	
	private static final Logger logger = Logger.getLogger(CoreController.class);
	
	@Autowired
	private SignUtil signUtil;
	
	@Autowired
	private WeixinService weixinService;
	
	/**
	 * 
	 * @description     微信认证方法
	 * @author          lujiawei
	 * @data            2017年1月31日 下午5:16:03
	 * @version         v1.0
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	/*@RequestMapping("/core")
	@ResponseBody
	public String core(String signature,String timestamp,String nonce,String echostr){
		logger.info("微信验证开始......");
		if(signUtil.checkSignature(signature, timestamp, nonce)){
			logger.info("微信验证成功........");
			return echostr;
		}else{
			logger.info("##################################微信验证失败##################################");
			return null;
		}
	}*/
	
	@RequestMapping(value="/core",method=RequestMethod.POST,produces = "text/xml;charset=UTF-8")
	@ResponseBody
	public String core(String signature,String timestamp,String nonce,String echostr,
			HttpServletRequest request,HttpServletResponse response){
		
		String returnStr = "";  //需要返回的值
		String url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort();

		try {
			Map<String, String> map = weixinService.parseXml(request);
			String msgType = map.get("MsgType");
			
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(map.get("FromUserName"));
			textMessage.setFromUserName(map.get("ToUserName"));
			textMessage.setMsgType("text");
			textMessage.setCreateTime((new Date()).getTime());
			
			String content = "";
			if("text".equals(msgType)){
				content = map.get("Content");
				logger.info(map.get("FromUserName")+" 发送 "+content);
				if("绑定".equals(content)){
					url = url + "/wechat/bindingController/jumpBinding?weixin="+map.get("FromUserName");
					textMessage.setContent("<a href='"+url+"'>点击绑定</a>");
				}else if("查询成绩".equals(content)){
					url = url + "/wechat/parentsController/findStudentByWeixin?weixin="+map.get("FromUserName");
					textMessage.setContent("<a href='"+url+"'>点击查询</a>");
				}else{
					textMessage.setContent("如有问题，请与黎老师联系....");
				}
				returnStr = weixinService.textMessageToXml(textMessage);
			}else{
				//暂时只支持文本类型，不支持其他类型
				textMessage.setContent("暂时不支持此类型消息");
				returnStr = weixinService.textMessageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}
	
}
