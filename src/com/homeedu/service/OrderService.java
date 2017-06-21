package com.homeedu.service;

import org.springframework.stereotype.Service;

import com.homeedu.dao.DAOManager;
import com.homeedu.entity.Order;

@Service
public class OrderService extends BaseService{

	public boolean addNewOrder(Order newOrd){
		return getDaoManager().getOrderDAO().addNewOrder(newOrd);
	}
}
