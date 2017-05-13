package com.homeedu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homeedu.entity.test;

@Repository
public class TestUserDAO extends BaseDAO{

	
	public String getNameById(Integer id){
		ResultSetHandler<test> rsh=new BeanHandler<test>(test.class);
			try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT ID,NAME FROM TEST WHERE ID=?");

				test one=null;
				one=getQueryRunner().query(sqlBuilder.toString(),rsh,id);
				System.out.println(one.toString());
				return one.getName();
			}catch(SQLException e){
				return null;
			}
		}
		
}
