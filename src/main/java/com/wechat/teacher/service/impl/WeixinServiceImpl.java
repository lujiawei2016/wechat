package com.wechat.teacher.service.impl;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.teacher.message.resp.Article;
import com.wechat.teacher.message.resp.NewsMessage;
import com.wechat.teacher.message.resp.TextMessage;
import com.wechat.teacher.service.WeixinService;

/**
 * 
 * @description     微信实现类
 * @author          lujiawei
 * @data            2017年2月6日 下午10:25:08
 * @version         v1.0
 */
@Service
@Transactional
public class WeixinServiceImpl implements WeixinService {
	
	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 解析微信发过来的请求
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中  
	    Map<String, String> map = new HashMap<String, String>();  
	  
	    // 从request中取得输入流  
	    InputStream inputStream = request.getInputStream();  
	    // 读取输入流  
	    SAXReader reader = new SAXReader();  
	    Document document = reader.read(inputStream);  
	    // 得到xml根元素  
	    Element root = document.getRootElement();  
	    // 得到根元素的所有子节点  
		List<Element> elementList = root.elements();  
	  
	    // 遍历所有子节点  
	    for (Element e : elementList)  
	        map.put(e.getName(), e.getText());  
	  
	    // 释放资源  
	    inputStream.close();  
	    inputStream = null;  
	  
	    return map;  
	}

	/**
	 * 文本消息对象转换成xml
	 */
	@Override
	public String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());  
	    return xstream.toXML(textMessage); 
	}

	/**
	 * 图文消息对象转换成xml
	 */
	@Override
	public String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());  
	    xstream.alias("item", new Article().getClass());  
	    return xstream.toXML(newsMessage);
	}
	
	/**
	 * 扩展xstream，使其支持CDATA块
	 */
	private XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // 对所有xml节点的转换都增加CDATA标记  
	            boolean cdata = true;  
	  
	            @SuppressWarnings("unchecked")  
	            public void startNode(String name, Class clazz) {  
	                super.startNode(name, clazz);  
	            }  
	  
	            protected void writeText(QuickWriter writer, String text) {  
	                if (cdata) {  
	                    writer.write("<![CDATA[");  
	                    writer.write(text);  
	                    writer.write("]]>");  
	                } else {  
	                    writer.write(text);  
	                }  
	            }  
	        };  
	    }  
	});  

}
