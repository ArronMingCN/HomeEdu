package com.homeedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping("/home")
	public ModelAndView mainPage(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("/home");
	}
	
	/**
	 * @author Arron
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		
		
		
		
		ModelAndView loginPage=new ModelAndView("/login");
	return loginPage;
	}
	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/doTeaLogin")
	public ModelAndView doTeaLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView errorView = new ModelAndView("redirect:/login");
		String userId=request.getParameter("UserId");
		String password=request.getParameter("password");
		
		test dbtest=getServiceManager().getTestUserService().getTestById(userId);
		
		if(dbtest==null || !dbtest.getPassword().equals(password) ){
		
			return errorView;
		}else {
			loginSuccess(request, dbtest);
			String name=dbtest.getName();
			return new ModelAndView("/home","name",name);
		}
		
	}
	private void loginSuccess(HttpServletRequest request,test test) {
		//当登录成功时，记录登录的用户信息。
		request.setAttribute("loginUser", test);
	}
	
	
	
}
