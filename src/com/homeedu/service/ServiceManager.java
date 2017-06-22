package com.homeedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {
    @Autowired
	private ParentService parentService;
	@Autowired
	private MessageService messageService;

	@Autowired
	private TeacherService teacherService;

	
	
	public ParentService getParentService(){
		return parentService;
	}
	public MessageService getMessageService(){
		return messageService;
	}
	public TeacherService getTeacherService(){
		return teacherService;
	}


}
