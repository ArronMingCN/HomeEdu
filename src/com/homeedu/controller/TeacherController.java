package com.homeedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {
	@RequestMapping("teacher_login")
	public String teacher_login(){
		return "success";
	}
}
