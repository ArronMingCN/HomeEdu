package com.homeedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.test;

@Controller
public class IndexController extends BaseController{

	
	/**
	 * 主页
	 * @author Arron
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView mainPage(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("/index");
	}
	
	/**
	 * @author Arron
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/LoginRegister")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView loginPage=new ModelAndView("/LoginRegister");
	return loginPage;
	}
	
	@RequestMapping("/teacher_register")
	public ModelAndView teacher_register(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("");
	}
	
	@RequestMapping("/login_out")
	public ModelAndView login_out(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession(false);
		if(session==null){
			return new ModelAndView("redirect:/index");
		}
		session.invalidate();
		return new ModelAndView("redirect:/index");
	}
	
}
