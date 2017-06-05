package com.homeedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Parent;


@Controller
public class ParentController extends BaseController{
	
	@RequestMapping("/student_login")
	public ModelAndView parent_login(HttpServletRequest request,HttpServletResponse response){
		
		String newId=request.getParameter("user_id");
		Parent dbParent=getServiceManager().getParentService().getParentById(newId);
		if(dbParent==null){
			//返回用户名或密码错误
			addReturnMsg("用户名或密码错误");
			System.out.println("没找到对象，密码或用户名错误");
			return new ModelAndView("/LoginRegister");
		}
		String password=request.getParameter("user_password");
		if(dbParent.getPassword().equals(password)){
			//登录成功，记录进session
			System.out.println("登录成功");
			request.getSession().setAttribute(SESSION_LOGIN_USER, dbParent);
			return new ModelAndView("/index");
		}
		else{
			//返回用户名或密码错误
			addReturnMsg("用户名或密码错误");
			System.out.println("找到对象，密码或用户名错误");
			return new ModelAndView("redirect:/LoginRegister");
		}
	}
	@RequestMapping("parent_center")
	public ModelAndView parent_center(HttpServletRequest request,HttpServletResponse response){
		if(request.getSession().getAttribute(SESSION_LOGIN_USER)==null){
			return new ModelAndView("redirect:/student_login");
		}
		return new ModelAndView("/info_add");
		
	}

	@RequestMapping("/student_register")
	public ModelAndView parent_register(HttpServletRequest request,HttpServletResponse response){
		String newId=request.getParameter("UserId");
		
		if(getServiceManager().getParentService().isIdExists(newId)==true){
			//已存在返回错误信息
		}
		String password=request.getParameter("password");
		String name=request.getParameter("password");
		String id_num=request.getParameter("password");
		String telephone=request.getParameter("password");
		Integer level=1;
		Parent newParent=new Parent(newId,name,password,id_num,telephone,level);
		return new ModelAndView("");
	}
	
	
}
