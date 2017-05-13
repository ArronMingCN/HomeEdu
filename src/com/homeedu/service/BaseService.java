package com.homeedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeedu.dao.DAOManager;

public class BaseService {

	@Autowired
	private DAOManager daoManager;
	
	public DAOManager getDaoManager(){
		return daoManager;
	}
	@Autowired
	private ServiceManager serviceManager;
	
	public ServiceManager getServiceManager(){
		return serviceManager;
	}
}
