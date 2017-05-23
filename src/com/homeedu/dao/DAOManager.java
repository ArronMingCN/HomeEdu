package com.homeedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOManager {

	@Autowired
	private TestUserDAO testUserDAO;
	
	@Autowired
	private ParentDAO parentDAO;
	
	public TestUserDAO getTestUserDAO(){
		return testUserDAO;
	}
	
	public ParentDAO getParentDAO(){
		return parentDAO;
	}
}
