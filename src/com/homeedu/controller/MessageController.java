package com.homeedu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Message;
import com.homeedu.entity.Parent;
import com.homeedu.util.DateUtil;

@Controller
public class MessageController extends BaseController{

	/**
	 * 在学员页面展示所有的发布信息
	 * @return
	 */
	@RequestMapping("student_info")
	public ModelAndView showAllMessages(){
		List<Message> list=getServiceManager().getMessageService().getAllShowMessages();
		return new ModelAndView("/student_info","listOfMessages",list);
	}
	/**
	 * 展示信息发布的详情页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("showMessageDetail")
	public ModelAndView showDetailMessagePage(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		Message dbMessage=getServiceManager().getMessageService().getMessageById(id);
		if(dbMessage==null){
			return new ModelAndView("errPage");
		}
		return new ModelAndView("/order_show","message",dbMessage);
	}
	/**
	 * 添加新的发布内容
	 * @param request
	 * @param response
	 * @return
	 * 
	 */
	@RequestMapping("/addNewMessage")
	public ModelAndView addNewMessage(HttpServletRequest request,HttpServletResponse response){
	
		String surname=request.getParameter("contactName");
		String course1=request.getParameter("teachSubject");
		String student_gender=request.getParameter("student_gender");
		String student_grade=request.getParameter("teachGrade");
		String student_status=request.getParameter("teachStatus");
		String teacher_gender=request.getParameter("teacher_gender");
		String teach_location=request.getParameter("teachLocation");
		String teach_time=request.getParameter("teachTime");
		String salary=request.getParameter("teachSalary");
		String teach_request=request.getParameter("teachRequest");
		String teach_type=request.getParameter("teachWay");
		Parent sessionParent=(Parent) request.getSession().getAttribute(SESSION_LOGIN_STUDENT);
		if(sessionParent==null){
			return new ModelAndView("/student_profile");
		}
		String parent_id=sessionParent.getId();
		Message newMsg=new Message(surname,course1,student_gender,student_grade,student_status,teacher_gender,teach_location,teach_time,salary
				,teach_request,teach_type,parent_id);
		/*
		Message newMsg=new Message("王先生","物理", "男", "学生成绩不太好", "高中三年级", "女", "沈河区", "星期四和"
				+ "星期五的晚上，每次2小时", "150每小时", "希望老师有耐心，成绩好","教员上门","1001");
		*/
		boolean a=getServiceManager().getMessageService().addMessageService(newMsg);
		
		System.out.println(newMsg.toString());
		return new ModelAndView("/index");
	}
}


