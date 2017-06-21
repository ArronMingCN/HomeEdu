package com.homeedu.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Order;

@Service
public class OrderDAO extends BaseDAO {
	
	/**
	 * @author Elaine
	 * @param newOrd
	 * @return
	 */
	public boolean addNewOrder(Order newOrd){
		/*newOrd.setId(getMax());
		newOrd.setDeal_time("123");*/
		
		//add a new order
		try{
			getQueryRunner().update("INSERT INTO order"
					+ "(id,teacer_id,parent_id,message_id,deal,deal_time) VALUES"
					+ "(?,?,?,?,?,?)",
					newOrd.getId(),newOrd.getTeacher_id(),newOrd.getParent_id(),newOrd.getMessage_id(),newOrd.getDeal(),newOrd.getDeal_time());
			return true;					
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
}
