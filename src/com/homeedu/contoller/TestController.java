package com.homeedu.contoller;

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
	
	//这个类种写具体关于test的Controll的处理，这里是测试用。但是一个老师，一个家长，新的实体类要对应新的StuController这种样子，不容易混乱！记得类上面加@Conrtoller注解。Service加@Service注解
}
