package com.jung.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BController {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "log", required = false) String log,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();		
		
		if (log != null) {
			model.addObject("log", "before login!");
			model.setViewName("login");
		} 
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		} 
		//로그아웃 버튼 이후 이동하는 페이지 이름
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
			model.setViewName("mainFrame");
		}
		//model.setViewName("login");
		
		return model;		
	}
	
}
