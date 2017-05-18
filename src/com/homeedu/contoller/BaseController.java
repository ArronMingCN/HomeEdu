package com.homeedu.contoller;


import org.springframework.beans.factory.annotation.Autowired;


import com.homeedu.service.ServiceManager;



public class BaseController {
	@Autowired
	private ServiceManager serviceManager;
	
	public void setServiceManager(ServiceManager serviceManager){
		this.serviceManager=serviceManager;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

}
