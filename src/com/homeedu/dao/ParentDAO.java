package com.homeedu.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Parent;


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
	
}
