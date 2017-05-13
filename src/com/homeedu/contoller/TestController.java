package com.homeedu.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController extends BaseController{
	
	@RequestMapping("/index")
	public String mainPage(HttpServletRequest rq){//MVC�е�Control����������뵽��˴�
		//ҵ���߼�����
		Integer id=Integer.getInteger(rq.getParameter("id"));//��ȡ��ǰ�˴�������idֵ��ͨ�����ݿ��ѯ
		getServiceManager().getTestUserService().getTestUserNameById(id);
		return "success";
		//return new ModelAndView("success","test",name);//MVC�е�View���������Ӧ����ͼ����Ⱦ���������
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
