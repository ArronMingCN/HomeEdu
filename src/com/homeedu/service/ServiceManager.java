package com.homeedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {

	@Autowired
	private TestUserService testUserService;
	
	public TestUserService getTestUserService(){
		return testUserService;
	}
}
