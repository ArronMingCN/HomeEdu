package com.homeedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController extends BaseController{
	
	@RequestMapping("/teaHome")
	public ModelAndView TeaHome(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("/teaHome");
	}
	
	//�������д�������test��Controll�Ĵ��?�����ǲ����á�����һ����ʦ��һ���ҳ����µ�ʵ����Ҫ��Ӧ�µ�StuController�������ӣ������׻��ң��ǵ��������@Conrtollerע�⡣Service��@Serviceע��
}
