package com.homeedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Message;
import com.homeedu.entity.Teacher;


@Controller
public class IndexController extends BaseController{

	@RequestMapping("/study")
	public ModelAndView study(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("/study");
	}
	
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("/about");
	}
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("/index");
	}
	
	@RequestMapping("/top")
	public ModelAndView top(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("/top");
	}
	
	/**
	 * 主页
	 * @author Arron
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mainPage")
	public ModelAndView mainPage(HttpServletRequest request,HttpServletResponse response){
		//System.out.print("this is in indexController:\n"+getServiceManager().getMessageService().getIndexShowMessages().toString());
		List<Message> list=getServiceManager().getMessageService().getIndexShowMessages();
		List<Teacher> listofTeachers=getServiceManager().getTeacherService().getIndexShowTeachers();
		request.setAttribute("listOfTeachers", listofTeachers);
		return new ModelAndView("/mainPage","listOfMessages",list);
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
