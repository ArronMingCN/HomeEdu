package com.homeedu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homeedu.entity.Parent;


@Controller
public class ParentController extends BaseController{

	@RequestMapping("/addNewParent")
	public ModelAndView addNewParent(HttpServletRequest request){
		
		//从前端获取值 然后初始化新实例ֵ
		Parent par=new Parent();
		par.setId(1001);
		par.setName("王二小");
		par.setPassword("123456");
		par.setID_num(500236);//这里的数据类型有问题
		par.setProvince("辽宁省");
		par.setCity("沈阳市");
		par.setDistrict("和平区");
		par.setTelephone(136353);
		par.setLevel(1);
		
		boolean a=getServiceManager().getParentService().addNewParent(par);
		
		System.out.print(a);
		return new ModelAndView("/home");
	}
}
