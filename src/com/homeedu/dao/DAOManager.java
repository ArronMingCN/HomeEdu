package com.homeedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.dialect.odps.visitor.OdpsASTVisitor;

@Service("daoManager")
public class DAOManager {

	@Autowired
	private TestUserDAO testUserDAO;
	
	@Autowired
	private ParentDAO parentDAO;
	
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private OrderDAO orderDAO;
	
	
	public TestUserDAO getTestUserDAO(){
		return testUserDAO;
	}
	
	public ParentDAO getParentDAO(){
		return parentDAO;
	}
	
	public MessageDAO getMessageDAO(){
		return messageDAO;
	}	
	public TeacherDAO getTeacherDAO(){
		return teacherDAO;
	}
	public OrderDAO getOrderDAO(){
		return orderDAO;
	}
}
