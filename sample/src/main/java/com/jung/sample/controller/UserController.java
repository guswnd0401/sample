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
	
	//ȸ������
	@RequestMapping("join")
	public String join(HttpServletRequest request, Model model) {
		
		//��й�ȣ ��ȣȭ ���� �߰� �κ�
		System.out.println("��й�ȣ ��ȣȭ ����");
		String u1Pw = request.getParameter("user_pw"); // �Է��� ��й�ȣ ���� u1Pw�� ����
		String uPw_org = u1Pw;
		u1Pw = passwordEncoder.encode(uPw_org);//��ȣȭ �ܰ�	
		System.out.println(u1Pw);		
		System.out.println("��й�ȣ ��ȣȭ ��ȯ");
		//��й�ȣ ��ȣȭ ��������� �߰��κ� �ؿ� ��й�ȣ�� �տ��� request.getParameter�� �޾ƿͼ� �ٷ� �׳� �Է�
		
		String result = 
		dao.join(request.getParameter("user_id"), u1Pw, request.getParameter("user_name"),
						request.getParameter("user_sex"), request.getParameter("user_email"), request.getParameter("user_phone"),
						request.getParameter("user_profile"), request.getParameter("user_ag1"), request.getParameter("user_ag2"));
		
		System.out.println("�������� : " + result);
		
		if(result.equals("join-success")) {
			System.out.println("���� ����");	
			return "redirect:login_view";
		}
		else {
			System.out.println("���� ����");
			return "join_view";//���� ������ �ϳ����� ����̳� �������� �ٷ� ȸ�������������� �Ѿ���ص���.
		}
			
		//System.out.println("���� ����");		
		//return "redirect:login_view";
		
	}
	
	//ȸ������ ���̵� �ߺ�üũ
	@RequestMapping("IdCheck")
		public @ResponseBody String IdCheck(UserDto dto1) {
		System.out.println("���̵� �ߺ��˻� ����");
		String result = null;
		
		try {
		
			String str = dao.IdCheck(dto1); //dao���� ���̵� ��������
		
			if(str == null) {
				System.out.println("DB�� ���̵� ����");
				result = "ok";
			}
			else {
				System.out.println("DB�� ���̵� ����");
				result = "no";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	
		return result;
	
	}
		
	//ȸ�� ����Ʈ
	@RequestMapping("ȸ�����")
	public String List(Model model) {
		model.addAttribute("List", dao.userlist()); //���⼭ "list�� jsp���� c:forEach items ���� �־�� �Ǵ� ���̴�.
		System.out.println("dao : " + dao.userlist());
		return "userlist"; 
	}

	///////////////// ���������� ����
	
	//�α���
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "log", required = false) String log,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		System.out.println("�α��� ��Ʈ�ѷ��� ����");
		
		ModelAndView model = new ModelAndView();		
		
		if (log != null) {
			System.out.println("�α�����������");
			model.addObject("log", "before login!");
			model.setViewName("login");
		} 
		if (error != null) {
			System.out.println("�����߻�");
			model.addObject("error", "Invalid username and password!");
		} 
		//�α׾ƿ� ��ư ���� �̵��ϴ� ������ �̸�
		if (logout != null) {
			System.out.println("�α׾ƿ���");
			model.addObject("msg", "You've been logged out successfully.");
			model.setViewName("main_view");
		}
		//model.setViewName("login");
		
		return model;		
	}
	
}