package com.jung.sample.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jung.sample.dao.StoreDao;
import com.jung.sample.dto.ApplyDto;

@Controller
public class BossController {

	@Autowired
	private StoreDao dao;
	
	//�������� ���
	@RequestMapping("apply")
	public String apply(HttpServletRequest request, Model model) {
		
		dao.apply(request.getParameter("asName"), request.getParameter("abNo"),
						request.getParameter("asLat"), request.getParameter("asLng"), request.getParameter("asAd"),
						request.getParameter("asPhone"), request.getParameter("asCategory"), request.getParameter("user_id"));
		
		System.out.println("��� ����");		
		return "redirect:ApplyList";
		
	}
	
	//�������� ����Ʈ
	@RequestMapping("ApplyList")
	public String applylist(Model model) {
		model.addAttribute("applylist", dao.applylist()); //���⼭ "list�� jsp���� c:forEach items ���� �־�� �Ǵ� ���̴�.
		System.out.println("dao : " + dao.applylist());
		return "StoreApplyList_view"; 
	}
	
	//�������� ����ȭ��
	@RequestMapping("/ApplyContent")
	public String ApplyContent(HttpServletRequest request, Model model) {
		System.out.println("��Ʈ�ѷ� ����");
		
		int no = Integer.parseInt(request.getParameter("asNo"));
		
		ArrayList<ApplyDto> dto = dao.ApplyContent(no);
		model.addAttribute("modify", dto);
		
		return "StoreApplyContent_view";
		
	}
	
	//�������� ����
	@RequestMapping("ApplyModify")
	public String ApplyModify(HttpServletRequest request, Model model) {
		
		dao.ApplyModify(request.getParameter("asName"), request.getParameter("abNo"),
						request.getParameter("asLat"), request.getParameter("asLng"), request.getParameter("asAd"),
						request.getParameter("asPhone"), request.getParameter("asCategory"));
		
		System.out.println("���� ����");		
		return "redirect:ApplyList";
		
	}
	
	//�������� �󼼺��� ����Ʈ
	
}
