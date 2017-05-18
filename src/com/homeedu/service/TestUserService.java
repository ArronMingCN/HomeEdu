package com.homeedu.service;

import org.springframework.stereotype.Service;

import com.homeedu.dao.TestUserDAO;
import com.homeedu.entity.test;
import com.homeedu.service.BaseService;

@Service
public class TestUserService extends BaseService{

	public test getTestById(String userId){
		return getDaoManager().getTestUserDAO().getTestById(userId);
	}
	
}
