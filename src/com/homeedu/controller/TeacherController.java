package com.homeedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Teacher;


@Controller
public class TeacherController extends BaseController{
	
	@RequestMapping("teacher_info")
	public ModelAndView teacher_info(HttpServletRequest request,HttpServletResponse response){
		
		List<Teacher> list=getServiceManager().getTeacherService().showAllTeachers();
		return new ModelAndView("teacher_info","listOfTeachers",list);
	}
	
	
	@RequestMapping("/teacher_login")
	public ModelAndView parent_login(HttpServletRequest request,HttpServletResponse response){
		
		String newId=request.getParameter("user_id");
		Teacher dbTeacher=getServiceManager().getTeacherService().getTeacherById(newId);
		if(dbTeacher==null){
			//返回用户名或密码错误
			addReturnMsg("用户名或密码错误");
			System.out.println("没找到对象，密码或用户名错误");
			return new ModelAndView("/LoginRegister");
		}
		String password=request.getParameter("user_password");
		if(dbTeacher.getPassword().equals(password)){
			//登录成功，记录进session
			System.out.println("登录成功");
			request.getSession().setAttribute(SESSION_LOGIN_USER, dbTeacher);
			return new ModelAndView("/index");
		}
		else{
			//返回用户名或密码错误
			addReturnMsg("用户名或密码错误");
			System.out.println("找到对象，密码或用户名错误");
			return new ModelAndView("redirect:/LoginRegister");
		}
	}
	@RequestMapping("teacher_center")
	public ModelAndView Teacher_center(HttpServletRequest request,HttpServletResponse response){
		if(request.getSession().getAttribute(SESSION_LOGIN_USER)==null){
			return new ModelAndView("redirect:/teacher_login");
		}
		return new ModelAndView("/info_add");
		
	}

	@RequestMapping("/teacher_register")
	public ModelAndView parent_register(HttpServletRequest request,HttpServletResponse response){
		String newId=request.getParameter("UserId");
		
		if(getServiceManager().getParentService().isIdExists(newId)==true){
			//已存在返回错误信息
		}
		String password=request.getParameter("password");
		String name=request.getParameter("password");
		String gender=request.getParameter("password");
		
		//Teacher newTeacher=new Teacher(newId,name,password,gender);
		Teacher newTeacher=new Teacher("1001","王","436603","m");
		getServiceManager().getTeacherService().addNewTeacher(newTeacher);
		
		return new ModelAndView("");
	}
	
	
}
