package com.homeedu.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.test;

@Controller
public class IndexController extends BaseController{

	
	/**
	 * 申请主页
	 * @author Arron
	 * @param request
	 * @param response
	 * @return 返回主页面
	 */
	@RequestMapping("/home")
	public ModelAndView mainPage(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("/home");
	}
	
	/**
	 * 申请登录页面
	 * @author Arron
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView loginPage=new ModelAndView("/login");
	return loginPage;
	}
	/**
	 * 具体处理登录逻辑
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/doTeaLogin")
	public ModelAndView doTeaLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView errorView = new ModelAndView("redirect:/login");
		String userId=request.getParameter("UserId");//获取从前端传过来的用户名值，通过数据库查询
		String password=request.getParameter("password");//获取前端传来的密码
		//这里应该处理Teacher表，这里先测试tes表
		test dbtest=getServiceManager().getTestUserService().getTestById(userId);
		if(dbtest==null || !dbtest.getPassword().equals(password) ){
			
			//返回错误页面
			return errorView;
		}else {
			loginSuccess(request, dbtest);
			String name=dbtest.getName();
			return new ModelAndView("/home","name",name);//这里同时传值回前端
		}
		
	}
	private void loginSuccess(HttpServletRequest request,test test) {
		//处理登录后的一些信息更新等等，最重要的会话保存
		
		request.setAttribute("loginUser", test);
	}
	
	
	
}
