package com.homeedu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Message;
import com.homeedu.entity.Teacher;

@Service
public class TeacherService extends BaseService{
	
	
	public List<Teacher> getTeachersById(List<String> list){
		return getDaoManager().getTeacherDAO().getTeachersById(list);
	}
	
	
	public boolean updatePartOfTeacher(Teacher ter){
		return getDaoManager().getTeacherDAO().updatePartOfTeacher(ter);
	}
	
	public List<Integer> getBooked(String teacherId){
		return getDaoManager().getTeacherDAO().getBookId(teacherId);
	}
	
	/**
	 * 更新教员的预约信息，即删除预约
	 * @param msgId
	 * @return
	 */
	public boolean updateTeacherBook(Integer msgId){
		return getDaoManager().getTeacherDAO().updateTeacherBook(msgId);
	}
	
	/**
	 * 更新教员剩余的预约的messageid
	 * @param msgId
	 * @param teacherId
	 * @param bookingLeft
	 * @return
	 */
	public boolean updateTeacherBooking1Id(Integer msgId,String teacherId){
		return getDaoManager().getTeacherDAO().updateTeacherBooking1Id(msgId, teacherId);
	}
	public boolean updateTeacherBooking2Id(Integer msgId,String teacherId){
		return getDaoManager().getTeacherDAO().updateTeacherBooking2Id(msgId, teacherId);
	}
	public boolean updateTeacherBooking3Id(Integer msgId,String teacherId){
		return getDaoManager().getTeacherDAO().updateTeacherBooking3Id(msgId, teacherId);
	}
	
	
	/**
	 * 返回所有教员信息list
	 * @return
	 */
	public List<Teacher> showAllTeachers(){
		return getDaoManager().getTeacherDAO().getIndexShowTeachers();
	}

	
	/**
	 * 添加教员对象
	 * @param newTea
	 * @return
	 */
	public boolean addNewTeacher(Teacher newTea){
		return getDaoManager().getTeacherDAO().addNewTeacher(newTea);
	}
	/**
	 * 注册用，看id是否已存在
	 * @param id
	 * @return
	 */
	public boolean isIdExists(String id){
		return getDaoManager().getTeacherDAO().isIdExits(id);
	}
	
	/**
	 * 通过id获得教员对象
	 * @param id
	 * @return
	 */
	public Teacher getTeacherById(String id){
		return getDaoManager().getTeacherDAO().getTeacherById(id);
	}
	
	public List<Teacher> getIndexShowTeachers(){
		return getDaoManager().getTeacherDAO().getIndexShowTeachers();
	}
}

