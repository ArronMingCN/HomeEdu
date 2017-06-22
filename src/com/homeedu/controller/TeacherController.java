package com.homeedu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Message;
import com.homeedu.entity.Parent;
import com.homeedu.entity.Teacher;


@Controller
public class TeacherController extends BaseController{
	
	/**
	 * 教员预约发布
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("bookMessage")
	public ModelAndView bookMessage(HttpServletRequest request,HttpServletResponse response){
		
		String errorMessage="null";
		Teacher loginOldTeacher=(Teacher) request.getSession().getAttribute(SESSION_LOGIN_TEACHER);
		
		if(loginOldTeacher==null){
			errorMessage="请教员先登录";
			return new ModelAndView("/errorPage","errorMessage",errorMessage);
		}
		else{
			errorMessage="您的预约次数或该发布预约已满，请清理预约发布或重新选择发布信息。给您带来的不便敬请谅解！";
		}
		Teacher loginTeacher=getServiceManager().getTeacherService().getTeacherById(loginOldTeacher.getId());
		String msgId=request.getParameter("id");
		Message dbmsg=getServiceManager().getMessageService().getMessageById(msgId);
		ModelAndView errorModelAndView=new ModelAndView("/errorPage","errorMessage",errorMessage);
		if(dbmsg==null){
			return errorModelAndView;
		}
		
		//若是有登录的教员和传来的发布信息的id则开始验证
		//查询teacher剩余的book位置
		Integer teacherBookingLeft=0;//教员还剩下的预约次数
		if(loginTeacher.getBookMessage1()==null){
			teacherBookingLeft=1;
		}else if(loginTeacher.getBookMessage2()==null){
			teacherBookingLeft=2;
		}else if(loginTeacher.getBookMessage3()==null){
			teacherBookingLeft=3;
		}else{
		
			return errorModelAndView;//这里应该是没有提示没有剩余的预约次数
		}
		//查询Message剩余的Book位置
		Integer messageBookingLeft=0;;//没有剩余
		if(dbmsg.getBookTeacher1()==null){
			messageBookingLeft=1;
		}else if(dbmsg.getBookTeacher2()==null){
			messageBookingLeft=2;
		}else if(dbmsg.getBookTeacher3()==null){
			messageBookingLeft=3;
		}else{
			return errorModelAndView;//这里应该是提示该信息发布 预约已满
		}
		System.out.println("teacherBookingleft:"+teacherBookingLeft+",messageBookingleft:"+messageBookingLeft);
		//若都满足 则开始插入    先往Message中插入Teacher id 
		boolean a=false,b=false;
		
		if(messageBookingLeft==1){
			a=getServiceManager().getMessageService().updateMessageBookTeacher1Id(loginTeacher.getId(), dbmsg.getId());
		}else if(messageBookingLeft==2){
			a=getServiceManager().getMessageService().updateMessageBookTeacher2Id(loginTeacher.getId(), dbmsg.getId());
		}else if(messageBookingLeft==3){
			a=getServiceManager().getMessageService().updateMessageBookTeacher3Id(loginTeacher.getId(), dbmsg.getId());
		}else{
			return errorModelAndView;
		}
		
		if(teacherBookingLeft==1){
			b=getServiceManager().getTeacherService().updateTeacherBooking1Id(dbmsg.getId(), loginTeacher.getId());
		}else if(teacherBookingLeft==2){
			b=getServiceManager().getTeacherService().updateTeacherBooking2Id(dbmsg.getId(), loginTeacher.getId());
		}else if (teacherBookingLeft==3){
			b=getServiceManager().getTeacherService().updateTeacherBooking3Id(dbmsg.getId(), loginTeacher.getId());
		}else{
			return errorModelAndView;
		}
		
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
		System.out.println(id);
		Teacher db=getServiceManager().getTeacherService().getTeacherById(id);
		Parent par=(Parent) request.getSession().getAttribute(SESSION_LOGIN_STUDENT);
		if(par==null){
			db.setTelephone("请先作为家长登录");
		}
		return new ModelAndView("/teacher/teacher_public","teacher",db);
	}
	@RequestMapping("teacher_info_add")
	public ModelAndView teacher_info_add(HttpServletRequest request,HttpServletResponse response){
		Teacher teacher=(Teacher) request.getSession().getAttribute(SESSION_LOGIN_TEACHER);
		return new ModelAndView("/teacher/teacher_info_add","teacher",teacher);
		
	}
	@RequestMapping("do_teacher_info_add")
	public ModelAndView do_teacher_info_add(HttpServletRequest request,HttpServletResponse response){
		Teacher teacher=(Teacher) request.getSession().getAttribute(SESSION_LOGIN_TEACHER);
		
		String school=request.getParameter("teacher_school");
		String major=request.getParameter("teacher_major");
		String gpa=request.getParameter("teacher_gpa");
		String course1=request.getParameter("teacher_subject");
		String introduction=request.getParameter("teacher_description");
		teacher.setSchool(school);
		teacher.setMajor(major);
		teacher.setGPA(gpa);
		teacher.setCourse1(course1);
		teacher.setIntroduction(introduction);
		System.out.print(teacher.toString());
		getServiceManager().getTeacherService().updatePartOfTeacher(teacher);
		//return new ModelAndView("/teacher/teacher_info_add","teacher",teacher);
		return new ModelAndView("redirect:/teacher_center");
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
		Teacher teacher=(Teacher) request.getSession().getAttribute(SESSION_LOGIN_TEACHER);
		if(teacher==null){
			return new ModelAndView("redirect:/teacher_login");
		}
		String teacherId=teacher.getId();
		System.out.print(teacherId);
		List<Integer> getIds=getServiceManager().getTeacherService().getBooked(teacherId);
		System.out.print(getIds.toString());
		List<Message> getMessages=getServiceManager().getMessageService().getTeacherBookingMessages(getIds);
		List<Message> getSuccessOrder=getServiceManager().getMessageService().getSuccessOrderMessage(teacherId);
		request.setAttribute("bookMessages", getMessages);
		request.setAttribute("successOrders", getSuccessOrder);
		return new ModelAndView("/teacher/teacher_order","teacher",teacher);
		
	}

	@RequestMapping("/teacher_register")
	public ModelAndView parent_register(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newId=request.getParameter("username");
		if(getServiceManager().getTeacherService().isIdExists(newId)){
			//已存在返回错误信息
			return new ModelAndView("/errorPage");
		}
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String Tele=request.getParameter("Tele");
		
		Teacher newTeacher=new Teacher(newId,name,password,Tele);
		System.out.print(newTeacher.toString());
		getServiceManager().getTeacherService().addNewTeacher(newTeacher);
		
		return new ModelAndView("/LoginRegister");
	}
	
	
}
