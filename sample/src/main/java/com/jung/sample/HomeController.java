package com.jung.sample;

import java.text.DateFormat;


import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.sample.dao.UserDao;
import com.jung.sample.dto.UserDto;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired //servlet-context.xml의 bean과 매핑
	private SqlSession sqlSession;	
	
	@Autowired
	private UserDao dao;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	//홈 = main
	@RequestMapping("home") //홈은 메인
	public String home() {
		return "main_view";
	}
	
	//회원가입화면 이동
	@RequestMapping("join_view")
	public String join_view() {
		return "join_view";
	}
	
	//메인화면에서 로그인클릭하여 로그인페이지 이동
	@RequestMapping("login_view")
	public String login_view() {
		return "login";
	}
	
	//로그인화면에서 로그인할 때  
	@RequestMapping("login")
	public String login() {
		return "redirect:home";
	}

	//===================================== 관리자 페이지
	//관리자 가게등록 페이지
	@RequestMapping("StoreRegister")
	public String Store_Register() {
		return "StoreRegister_view";
	}
	
	
	//====================================== 사장페이지
	//입점문의 페이지
	@RequestMapping("StoreApply")
	public String StoreApply() {
		return "StoreApply_view";
	}
	
	//입점문의 수정
	
	
	//입점문의 삭제
	
	
	//메뉴등록 및 추가
	@RequestMapping("Menu_apply")
	public String Menu_apply() {
		return "MenuApply_view";
	}
	
	//메뉴수정
	
	
	//메뉴삭제
	
	
	//메뉴리스트
	
}