package com.homeedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Message;
import com.homeedu.entity.Teacher;


@Controller
public class TeacherController extends BaseController{
	
	@RequestMapping("bookMessage")
	public ModelAndView bookMessage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView errorPage=new ModelAndView("/errorPage");
		Teacher loginTeacher=(Teacher) request.getSession().getAttribute(SESSION_LOGIN_TEACHER);
		if(loginTeacher==null){
			return errorPage;
		}
		String msgId=request.getParameter("id");
		Message dbmsg=getServiceManager().getMessageService().getMessageById(msgId);
		
		if(dbmsg==null){
			return errorPage;
		}
		
		//若是有登录的教员和传来的发布信息的id则开始验证
		//查询teacher剩余的book位置
		String teacherBookingLeft="wuwuwu";//教员还剩下的预约次数
		if(loginTeacher.getBookMessage1()==null){
			teacherBookingLeft="bookMessage1";
		}else if(loginTeacher.getBookMessage2()==null){
			teacherBookingLeft="bookMessage2";
		}else if(loginTeacher.getBookMessage3()==null){
			teacherBookingLeft="bookMessage3";
		}else{
			return errorPage;//这里应该是没有提示没有剩余的预约次数
		}
		//查询Message剩余的Book位置
		String messageBookingLeft="wuwuwu";//没有剩余
		if(dbmsg.getBookTeacher1()==null){
			teacherBookingLeft="bookTeacher1";
		}else if(dbmsg.getBookTeacher2()==null){
			teacherBookingLeft="bookTeacher2";
		}else if(dbmsg.getBookTeacher3()==null){
			teacherBookingLeft="bookTeacher3";
		}else{
			return errorPage;//这里应该是提示该信息发布 预约已满
		}
		//若都满足 则开始插入    先往Message中插入Teacher id 
		boolean a=getServiceManager().getMessageService().updateMessageBookTeacherId(loginTeacher.getId(), dbmsg.getId(), messageBookingLeft);
		boolean b=getServiceManager().getTeacherService().updateTeacherBookingId(dbmsg.getId(), loginTeacher.getId(), teacherBookingLeft);
		System.out.println(a+","+b);
		return new ModelAndView("/index");
	}
	
	
	
	/**
	 * 展示所有教元信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("teacher_info")
	public ModelAndView teacher_info(HttpServletRequest request,HttpServletResponse response){
		
		List<Teacher> list=getServiceManager().getTeacherService().showAllTeachers();
		return new ModelAndView("teacher_info","listOfTeachers",list);
	}
	
	/**
	 * 返回教师对外展示页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("showTeacherDetail")
	public ModelAndView showTeacherDetail(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		Teacher db=getServiceManager().getTeacherService().getTeacherById(id);
		
		return new ModelAndView("teacher_show","teacher",db);
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
			request.getSession().setAttribute(SESSION_LOGIN_TEACHER, dbTeacher);
		
			return new ModelAndView("redirect:/index");
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
		if(request.getSession().getAttribute(SESSION_LOGIN_TEACHER)==null){
			return new ModelAndView("redirect:/teacher_login");
		}
		return new ModelAndView("/teacher_profile");
		
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
