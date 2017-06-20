package com.homeedu.service;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Teacher;

@Service
public class TeacherService extends BaseService{
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
}
