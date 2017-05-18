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
	 * ������ҳ
	 * @author Arron
	 * @param request
	 * @param response
	 * @return ������ҳ��
	 */
	@RequestMapping("/home")
	public ModelAndView mainPage(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("/home");
	}
	
	/**
	 * �����¼ҳ��
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
	 * ���崦���¼�߼�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/doTeaLogin")
	public ModelAndView doTeaLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView errorView = new ModelAndView("redirect:/login");
		String userId=request.getParameter("UserId");//��ȡ��ǰ�˴��������û���ֵ��ͨ�����ݿ��ѯ
		String password=request.getParameter("password");//��ȡǰ�˴���������
		//����Ӧ�ô���Teacher�������Ȳ���tes��
		test dbtest=getServiceManager().getTestUserService().getTestById(userId);
		if(dbtest==null || !dbtest.getPassword().equals(password) ){
			
			//���ش���ҳ��
			return errorView;
		}else {
			loginSuccess(request, dbtest);
			String name=dbtest.getName();
			return new ModelAndView("/home","name",name);//����ͬʱ��ֵ��ǰ��
		}
		
	}
	private void loginSuccess(HttpServletRequest request,test test) {
		//�����¼���һЩ��Ϣ���µȵȣ�����Ҫ�ĻỰ����
		
		request.setAttribute("loginUser", test);
	}
	
	
	
}
