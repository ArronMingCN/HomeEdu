package com.homeedu.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.homeedu.entity.Message;
import com.homeedu.entity.Parent;
import com.homeedu.entity.Teacher;
import com.homeedu.util.DateUtil;


@Controller
public class ParentController extends BaseController{
	
	@RequestMapping("confirmTeacher")
	public ModelAndView confirmMessage(HttpServletRequest request,HttpServletResponse response){
		String errorNote="发生错误";
		ModelAndView error=new ModelAndView("/errorPage","errorMessage",errorNote);
		Parent loginParent=(Parent)request.getSession().getAttribute(SESSION_LOGIN_STUDENT);
		if(loginParent==null){
			errorNote="您没有登录";
			return error;
		}
		/*
		Integer msgId=Integer.getInteger(request.getParameter("msgId"));
		String teacherId=request.getParameter("teacherId");
		*/
		String teacherId= request.getParameter("id");
		Integer id=Integer.valueOf(request.getParameter("msgId"));
		String dealtime=DateUtil.getCurrentTimestamp().toString();
		boolean a=getServiceManager().getMessageService().updateMessageConfirm(teacherId, id, dealtime);
		boolean b=getServiceManager().getTeacherService().updateTeacherBook(id);
		if((a==true)&&(b==true)){
			return new ModelAndView("redirect:/parentMessages");
		}
		return error;
	}
	
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
			request.getSession().setAttribute(SESSION_LOGIN_STUDENT, dbParent);
			
			return new ModelAndView("redirect:/index");
		}
		else{
			//返回用户名或密码错误
			addReturnMsg("用户名或密码错误");
			System.out.println("找到对象，密码或用户名错误");
			return new ModelAndView("redirect:/LoginRegister");
		}
	}
	@RequestMapping("/parent_center")
	public ModelAndView parent_center(HttpServletRequest request,HttpServletResponse response){
		Parent par=(Parent)request.getSession().getAttribute(SESSION_LOGIN_STUDENT);
		if(par==null){
			return new ModelAndView("redirect:/student_login");
		}
		return new ModelAndView("/parent/student_profile","parent",par);
		
	}	
	@RequestMapping("/parentMessages")
	public ModelAndView ParentMessages(HttpServletRequest request,HttpServletResponse response){
		Parent par=(Parent)request.getSession().getAttribute(SESSION_LOGIN_STUDENT);
		if(par==null){
			return new ModelAndView("redirect:/student_login");
		}
		String parentId=par.getId();
		List<Message> bookinglist=getServiceManager().getMessageService().getBookingMessagesByParentId(parentId);
		List<Message> successlist=getServiceManager().getMessageService().getSuccesMessagesByParentId(parentId);
		request.setAttribute("bookinglist", bookinglist);
		request.setAttribute("successlist", successlist);
		return new ModelAndView("/parent/parent_order","parent",par);
		
	}

	/**
	 * 家长注册
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/student_register")
	public ModelAndView parent_register(HttpServletRequest request,HttpServletResponse response){
		String newId=request.getParameter("username");
		if(getServiceManager().getParentService().isIdExists(newId)==true){
			//已存在返回错误信息
		}
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String id_num=request.getParameter("CardId");
		String telephone=request.getParameter("Tele");
		Integer level=1;
		Parent newParent=new Parent(newId,name,password,id_num,telephone,level);
		System.out.println(newParent.toString());
		getServiceManager().getParentService().addNewParent(newParent);
		
		return new ModelAndView("/LoginRegister");
	}
	@RequestMapping("chooseTeacher")
	public ModelAndView chooseTeacher(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		Message msg=getServiceManager().getMessageService().getMessageById(id);//用语订单详情展示
		List<String> list=getServiceManager().getMessageService().getBookingTeachers(msg.getId());
		List<Teacher> listTeacher=getServiceManager().getTeacherService().getTeachersById(list);
		request.setAttribute("listOfTeachers", listTeacher);
		return new ModelAndView("/parent/order_choose","message",msg);
	}
}
