package com.homeedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Order;

@Controller
public class OrderController extends BaseController{
	
	@RequestMapping("/order_insert")
	public ModelAndView order_insert(HttpServletRequest request,HttpServletResponse response){
		
		Order newOrd = new Order();
		getServiceManager().getOrderService().addNewOrder(newOrd);
		return new ModelAndView("/index");
	}
}
