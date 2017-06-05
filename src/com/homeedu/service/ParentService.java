package com.homeedu.service;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Parent;

@Service
public class ParentService extends BaseService{
	public boolean addNewParent(Parent newPar){
		return getDaoManager().getParentDAO().addNewParent(newPar);
	}
	
	/**
	 * 注册用，看id是否已存在
	 * @param id
	 * @return
	 */
	public boolean isIdExists(String id){
		return getDaoManager().getParentDAO().isIdExits(id);
	}
	
	/**
	 * 通过id获得家长对象
	 * @param id
	 * @return
	 */
	public Parent getParentById(String id){
		return getDaoManager().getParentDAO().getParentById(id);
	}
}
