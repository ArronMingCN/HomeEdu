package com.homeedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Message;
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
	 */
	@RequestMapping("/addNewMessage")
	public ModelAndView addNewMessage(HttpServletRequest request,HttpServletResponse response){
		/*
		String surname=request.getParameter("");
		String c1=request.getParameter("");
		String c2=request.getParameter("");
		String c3=request.getParameter("");
		String sgrade=request.getParameter("");
		String sgender=request.getParameter("");
		String sstatus=request.getParameter("");
		String tgender=request.getParameter("");
		String tlocation=request.getParameter("");
		String ttime=request.getParameter("");
		String salary=request.getParameter("");
		String trequest=request.getParameter("");
		//Message newMsg=new Message(surname,c1,c2,c3,sgender,sgrade,sstatus,tgender,tlocation
			//	,ttime,salary,trequest);
		*/
		Message newMsg=new Message("王先生","物理", "数学", "生物", "男", "学生成绩不太好", "高中三年级", "女", "沈河区", "星期四和"
				+ "星期五的晚上，每次2小时", "150每小时", "希望老师有耐心，成绩好");
		
		boolean a=getServiceManager().getMessageService().addMessageService(newMsg);
		System.out.println(a);
		return new ModelAndView("/index");
	}
}
