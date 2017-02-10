package com.wechat.teacher.message.resp;

/**
 * 
 * @description     文本消息
 * @author          lujiawei
 * @data            2017年2月6日 下午10:39:16
 * @version         v1.0
 */
public class TextMessage extends BaseMessage {

	// 回复的消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}
