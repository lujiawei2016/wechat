package com.wechat.teacher.message.req;

/**
 * 
 * @description     文本消息 
 * @author          lujiawei
 * @data            2017年2月6日 下午10:35:55
 * @version         v1.0
 */
public class TextMessage extends BaseMessage {

	// 消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}
