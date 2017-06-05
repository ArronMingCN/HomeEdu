package com.homeedu.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.homeedu.service.ServiceManager;



public class BaseController {

	public static final String SESSION_LOGIN_USER = "LOGIN_USER";
	private static final String RETURN_MSG = "returnMsg";
	@Autowired
	private ServiceManager serviceManager;
	
	public void setServiceManager(ServiceManager serviceManager){
		this.serviceManager=serviceManager;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}
	
	
	/**
	 * 设置返回提示信息
	 * @param msg
	 */
	public void addReturnMsg(String msg){
		WebUtil.getSession().setAttribute(RETURN_MSG, msg);
	}
	/**
	 * 获取返回提示信息
	 */
	public void getReturnMsg(){
		HttpSession httpSession = WebUtil.getSession();
		WebUtil.getRequest().setAttribute(RETURN_MSG, (String)httpSession.getAttribute(RETURN_MSG));
		httpSession.removeAttribute(RETURN_MSG);
	}

}
