package com.homeedu.controller;
import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.homeedu.service.ServiceManager;
import com.homeedu.util.WebUtil;

public class BaseController {

	public static final String SESSION_LOGIN_TEACHER = "LOGIN_TEACHER";
	public static final String SESSION_LOGIN_STUDENT = "LOGIN_STUDENT";
	private static final String RETURN_MSG = "returnMsg";
	//商品图片根路径
	public static final String Teacher_IMAGES_PATH = "upload" + File.separator + "teacher_imgs" + File.separator;
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
