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
	
	//입점문의 등록
	@RequestMapping("apply")
	public String apply(HttpServletRequest request, Model model) {
		
		dao.apply(request.getParameter("asName"), request.getParameter("abNo"),
						request.getParameter("asLat"), request.getParameter("asLng"), request.getParameter("asAd"),
						request.getParameter("asPhone"), request.getParameter("asCategory"), request.getParameter("user_id"));
		
		System.out.println("등록 성공");		
		return "redirect:ApplyList";
		
	}
	
	//입점문의 리스트
	@RequestMapping("ApplyList")
	public String applylist(Model model) {
		model.addAttribute("applylist", dao.applylist()); //여기서 "list가 jsp에서 c:forEach items 값에 넣어야 되는 값이다.
		System.out.println("dao : " + dao.applylist());
		return "StoreApplyList_view"; 
	}
	
	//입점문의 수정화면
	@RequestMapping("/ApplyContent")
	public String ApplyContent(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 들어옴");
		
		int no = Integer.parseInt(request.getParameter("asNo"));
		
		ArrayList<ApplyDto> dto = dao.ApplyContent(no);
		model.addAttribute("modify", dto);
		
		return "StoreApplyContent_view";
		
	}
	
	//입점문의 수정
	@RequestMapping("ApplyModify")
	public String ApplyModify(HttpServletRequest request, Model model) {
		
		dao.ApplyModify(request.getParameter("asName"), request.getParameter("abNo"),
						request.getParameter("asLat"), request.getParameter("asLng"), request.getParameter("asAd"),
						request.getParameter("asPhone"), request.getParameter("asCategory"));
		
		System.out.println("수정 성공");		
		return "redirect:ApplyList";
		
	}
	
	//입점문의 상세보기 리스트
	
}
