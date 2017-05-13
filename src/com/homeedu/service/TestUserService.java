package com.homeedu.service;

import org.springframework.stereotype.Service;

import com.homeedu.service.BaseService;

@Service
public class TestUserService extends BaseService{

	public String getTestUserNameById(Integer id){
		return getDaoManager().getTestUserDAO().getNameById(id);
	}
	
}
