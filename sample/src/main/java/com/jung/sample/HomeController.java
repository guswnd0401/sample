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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main_view";//ùȭ��
	}
	
	//Ȩ = main
	@RequestMapping("home") //Ȩ�� ����
	public String home() {
		return "main_view";
	}
	
	//ȸ������ȭ�� �̵�
	@RequestMapping("join_view")
	public String join_view() {
		return "join_view";
	}
	
	//����ȭ�鿡�� �α���Ŭ���Ͽ� �α��������� �̵�
	@RequestMapping("login_view")
	public String login_view() {
		return "login";
	}
	
	//�α���ȭ�鿡�� �α����� ��  
	@RequestMapping("login")
	public String login() {
		System.out.println("�α���ȭ�鿡�� �α����� �� ");
		return "redirect:home";
	}
	
	//===================================== ������ ������
	//������ ���Ե�� ������
	@RequestMapping("StoreRegister")
	public String Store_Register() {
		return "StoreRegister_view";
	}
	
	
	//====================================== ����������
	//�������� ������
	@RequestMapping("StoreApply")
	public String StoreApply() {
		return "StoreApply_view";
	}
	
	//�������� ����
	
	
	//�������� ����
	
	
	//�޴���� �� �߰�
	@RequestMapping("Menu_apply")
	public String Menu_apply() {
		return "MenuApply_view";
	}
	
	//�޴�����
	
	
	//�޴�����
	
	
	//�޴�����Ʈ
}