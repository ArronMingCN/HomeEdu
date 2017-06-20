package com.homeedu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Message;

@Service
public class MessageService extends BaseService{

	public boolean addMessageService(Message msg){
		return getDaoManager().getMessageDAO().addNewMessage(msg);
	}
	/**
	 * 获得首页展示的发布信息
	 * @return
	 */
	public List<Message> getIndexShowMessages(){
		return getDaoManager().getMessageDAO().getIndexShowMessages();
	}
	/**
	 * 获得所有发布消息的list
	 * @return
	 */
	public List<Message> getAllShowMessages(){
		return getDaoManager().getMessageDAO().getAllShowMessages();
	}
	
	public Message getMessageById(String id){
		return getDaoManager().getMessageDAO().getMessageById(id);
	}
}
