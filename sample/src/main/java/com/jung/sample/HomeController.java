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

import com.jung.sample.dao.TestDao;
import com.jung.sample.dto.JoinDto;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired //servlet-context.xml의 bean과 매핑
	private SqlSession sqlSession;	
	
	@Autowired
	private TestDao dao;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping("home")
	public String home() {
		return "main";
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
	
	//회원가입2
	@RequestMapping("join")
	public String join2(HttpServletRequest request, Model model) {
		dao.join(request.getParameter("uId"), request.getParameter("uPw"),request.getParameter("uName"), request.getParameter("uEmail"),
		request.getParameter("uPhone"), request.getParameter("uAg1"), request.getParameter("uAg2"));
		return "redirect:login";
	}
	
	//메인페이지에서 회원가입 클릭시 회원가입페이지 이동.
	@RequestMapping("join_view")
		public String join_view2() {
		return "join2_view";
	}
	
	//회원가입2 아이디 중복체크
	@RequestMapping("IdCheck")
		public @ResponseBody String IdCheck(JoinDto dto1) {
		
		String result1 = null;
		
		try {
		
			String str = dao.IdCheck(dto1);
		
			if(str == null) {
				System.out.println("DB에 아이디가 없음");
				result1 = "ok";
			}
			else {
				System.out.println("DB에 아이디 존재");
				result1 = "no";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	
		return result1;
	
	}
	
}