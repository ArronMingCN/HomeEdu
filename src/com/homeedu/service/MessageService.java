package com.homeedu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Message;

@Service
public class MessageService extends BaseService{

	public List<String> getBookingTeachers(Integer msgId){
		return getDaoManager().getMessageDAO().getBookingTeachersById(msgId);
	}
	
	/**
	 * 获取预定的Msg列表 通过parentid
	 * @param parentId
	 * @return
	 */
	public List<Message> getBookingMessagesByParentId(String parentId){
		return getDaoManager().getMessageDAO().getBookingMessagesByParentId(parentId);
	}
	/**
	 * 通过parentid获取已完成的msgs
	 * @param parentId
	 * @return
	 */
	public List<Message> getSuccesMessagesByParentId(String parentId){
		return getDaoManager().getMessageDAO().getSuccessMessagesByParentId(parentId);
	}
	
	/**
	 * 通过教员id获取成功的msg
	 * @param teacherId
	 * @return
	 */
	public List<Message> getSuccessOrderMessage(String teacherId){
		return getDaoManager().getMessageDAO().getSuccessOrder(teacherId);
	}
	
	/**
	 * 获取教员的预约发布信息
	 * @param list
	 * @return
	 */
	public List<Message> getTeacherBookingMessages(List<Integer> list){
		return getDaoManager().getMessageDAO().getBookId(list);
	}
	
	
	/**
	 * 确认订单
	 * @param teacherId
	 * @param msgId
	 * @param dealTime
	 * @return
	 */
	public boolean updateMessageConfirm(String teacherId,Integer msgId,String dealTime){
		return getDaoManager().getMessageDAO().updateMessageConfirm(teacherId, msgId, dealTime);
	}
	
	/**
	 * 更新发布msgId的bookingleft位置上的TeacherId即bookId
	 * @param teacherId
	 * @param msgId
	 * @param bookingLeft
	 * @return
	 */
	public boolean updateMessageBookTeacher1Id(String teacherId,Integer msgId){
		return getDaoManager().getMessageDAO().updateMessageBook1Id(teacherId, msgId);
	}
	public boolean updateMessageBookTeacher2Id(String teacherId,Integer msgId){
		return getDaoManager().getMessageDAO().updateMessageBook2Id(teacherId, msgId);
	}
	public boolean updateMessageBookTeacher3Id(String teacherId,Integer msgId){
		return getDaoManager().getMessageDAO().updateMessageBook3Id(teacherId, msgId);
	}
	
	
	/**
	 * 添加新的发布信息
	 * @param msg
	 * @return
	 */
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
