package com.homeedu.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController extends BaseController{
	
	@RequestMapping("/index")
	public String mainPage(HttpServletRequest rq){//MVC中的Control概念，访问申请到达此处
		//业务逻辑处理
		Integer id=Integer.getInteger(rq.getParameter("id"));//获取从前端传过来的id值，通过数据库查询
		getServiceManager().getTestUserService().getTestUserNameById(id);
		return "success";
		//return new ModelAndView("success","test",name);//MVC中的View概念，返回相应的视图，渲染后发送浏览器
	}
	@RequestMapping("/abc")
	public ModelAndView hello(HttpServletRequest rq){
		ModelAndView test=new ModelAndView("success");
		Integer id=1;//for test
	try {
		System.out.println(getServiceManager().getTestUserService().getTestUserNameById(id));
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return test;
	}
	
	
	
}
