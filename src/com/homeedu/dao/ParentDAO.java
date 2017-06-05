package com.homeedu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Service;

import com.homeedu.entity.Parent;
import com.homeedu.entity.test;


@Service
public class ParentDAO extends BaseDAO{

	
	
	 /**
	  * @author Arron
	  * @param par
	  * @return
	  */
	public boolean addNewParent(Parent newPar){
		
		//add a new parent
		try {
			getQueryRunner().update("INSERT INTO parent "
					+ "(id,name,password,id_num,province,city,district,telephone,level) VALUES " +
					"(?,?,?,?,?,?,?,?,?)", 
					newPar.getId(),newPar.getName(),newPar.getPassword(),newPar.getID_num(),
					newPar.getProvince(),newPar.getCity(),newPar.getDistrict(),newPar.getTelephone(),newPar.getLevel());
			return true;
		} catch (SQLException e) {
			
			System.out.println(e);
			return false;
		}
	}
	/**
	 * 注册用，看id是否已存在
	 * @param id
	 * @return
	 */
	public boolean isIdExits(String id){
		ResultSetHandler<Parent> rsh=new BeanHandler<Parent>(Parent.class);
		Parent dbParent=null;
		try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT * FROM parent WHERE id=?");

				dbParent=getQueryRunner().query(sqlBuilder.toString(),rsh,id);		
				if(dbParent==null){
					return false;
				}
				return true;
			}catch(SQLException e){
				System.out.println(e);
				return false;
			}
	}
	
	public Parent getParentById(String id){
		ResultSetHandler<Parent> rsh=new BeanHandler<Parent>(Parent.class);
		Parent dbParent=null;
		try{
				StringBuilder sqlBuilder=new StringBuilder();
			sqlBuilder.append("SELECT * FROM parent WHERE id=?");

				dbParent=getQueryRunner().query(sqlBuilder.toString(),rsh,id);		
				if(dbParent==null){
					return null;
				}
				return dbParent;
			}catch(SQLException e){
				System.out.println(e);
				return null;
			}
	}
	
}
