package com.jung.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jung.sample.dao.UserDao;
import com.jung.sample.dto.UserDto;

@Controller
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//회원가입
	@RequestMapping("join")
	public String join(HttpServletRequest request, Model model) {
		
		//비밀번호 암호화 관련 추가 부분
		System.out.println("비밀번호 암호화 시작");
		String u1Pw = request.getParameter("user_pw"); // 입력한 비밀번호 값을 u1Pw에 저장
		String uPw_org = u1Pw;
		u1Pw = passwordEncoder.encode(uPw_org);//암호화 단계	
		System.out.println(u1Pw);		
		System.out.println("비밀번호 암호화 변환");
		//비밀번호 암호화 여기까지가 추가부분 밑에 비밀번호는 앞에서 request.getParameter로 받아와서 바로 그냥 입력
		
		String result = 
		dao.join(request.getParameter("user_id"), u1Pw, request.getParameter("user_name"),
						request.getParameter("user_sex"), request.getParameter("user_email"), request.getParameter("user_phone"),
						request.getParameter("user_profile"), request.getParameter("user_ag1"), request.getParameter("user_ag2"));
		
		System.out.println("성공여부 : " + result);
		
		if(result.equals("join-success")) {
			System.out.println("가입 성공");	
			return "redirect:login_view";
		}
		else {
			System.out.println("가입 실패");
			return "join_view";//실패 페이지 하나만들어서 모달이나 문구띄우고 바로 회원가입페이지로 넘어가게해도됨.
		}
			
		//System.out.println("가입 성공");		
		//return "redirect:login_view";
		
	}
	
	//회원가입 아이디 중복체크
	@RequestMapping("IdCheck")
		public @ResponseBody String IdCheck(UserDto dto1) {
		System.out.println("아이디 중복검사 시작");
		String result = null;
		
		try {
		
			String str = dao.IdCheck(dto1); //dao에서 아이디 가져오기
		
			if(str == null) {
				System.out.println("DB에 아이디가 없음");
				result = "ok";
			}
			else {
				System.out.println("DB에 아이디 존재");
				result = "no";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	
		return result;
	
	}
		
	//회원 리스트
	@RequestMapping("회원목록")
	public String List(Model model) {
		model.addAttribute("List", dao.userlist()); //여기서 "list가 jsp에서 c:forEach items 값에 넣어야 되는 값이다.
		System.out.println("dao : " + dao.userlist());
		return "userlist"; 
	}

	///////////////// 위에까지는 성공
	
	//로그인
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "log", required = false) String log,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		System.out.println("로그인 컨트롤러에 들어옴");
		
		ModelAndView model = new ModelAndView();		
		
		if (log != null) {
			System.out.println("로그인하지않음");
			model.addObject("log", "before login!");
			model.setViewName("login");
		} 
		if (error != null) {
			System.out.println("에러발생");
			model.addObject("error", "Invalid username and password!");
		} 
		//로그아웃 버튼 이후 이동하는 페이지 이름
		if (logout != null) {
			System.out.println("로그아웃함");
			model.addObject("msg", "You've been logged out successfully.");
			model.setViewName("main_view");
		}
		//model.setViewName("login");
		
		return model;		
	}
	
}