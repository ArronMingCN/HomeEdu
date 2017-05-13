package com.homeedu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;

public class BaseDAO {

	@Autowired
	protected DataSource dataSource=null;
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/homeedu");
		dataSource.setUsername("root");
		dataSource.setPassword("512959970");
		return dataSource;
		
	}
	private QueryRunner qr=null;
	public Connection getConnection(){
		
		try{
			return dataSource.getConnection();
		}catch(SQLException e){
			System.out.println("get connection failed:"+e);
			return null;
		}
	}
	
	public QueryRunner getQueryRunner(){
		if(qr==null){
			qr=new QueryRunner(dataSource);
		}
		return qr;
	}
}
