package com.jung.sample.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jung.sample.command.BCommand;
import com.jung.sample.command.SearchCommand;
import com.jung.sample.dao.StoreDao;
import com.jung.sample.dto.StoreDto;

@Controller
public class ManagerController {
	@Autowired
	private StoreDao dao;
	
	BCommand command = null;
	
	//가게등록
	@RequestMapping("register")
	public String register(MultipartHttpServletRequest request, Model model) {
		
		//===========================
		
		MultipartFile mf = request.getFile("sImg");
		//MultipartFile객체를 얻어냄, 이떄는 getParameter대신 getFile()메서드를 사용
		System.out.println(mf);
		
		String path = "D:/TeamProject/Store/";
		//폼에서 전달된 파일이름
		String originFileName = mf.getOriginalFilename();
		//업로드된 파일 크기
		long fileSize = mf.getSize();
		
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);		
		
		//저장할 파일은 이름을 바꾸어 저장(동일한 이름의 파일이 왔을때 중복 피함, 시간을 앞에 붙여 중복 피함)
		String safeFile = path + System.currentTimeMillis() + originFileName;
		String dfile = System.currentTimeMillis() + originFileName;
				
		try {
			mf.transferTo(new File(safeFile)); //MultipartFile객체를 일반 파일 객체로 변환
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//model.addAttribute("author", src);
		model.addAttribute("fileName", dfile);
		model.addAttribute("fileSize", fileSize);
		
		
		String imgname1 = request.getParameter("sImg");
		String Simg = imgname1;
		
		Simg = dfile;
		
		//===========================
		
		int Tip = Integer.parseInt(request.getParameter("sTip"));
		int Price = Integer.parseInt(request.getParameter("mPrice"));
		
		dao.Register(request.getParameter("sName"), request.getParameter("bName"), request.getParameter("bNo"), Simg, request.getParameter("sAd"),
						request.getParameter("sLat"), request.getParameter("sLng"), request.getParameter("sPhone"), request.getParameter("sCategory"),
						Tip, Price, request.getParameter("user_id"));
		
		System.out.println("등록 성공");		
		return "redirect:StoreList";
		
	}
	
	//가게 리스트
	@RequestMapping("StoreList")
	public String StoreList(Model model) {
		
		ArrayList<StoreDto> str = dao.Storelist();
		System.out.println("dao : " + dao.Storelist());
		System.out.println("str : " + str);
		
		if(str.isEmpty()) {
			System.out.println("목록이 없다.");
			return "NoneStore";
		}
		else {
			System.out.println("목록있음");
			model.addAttribute("storelist", str);
			return "StoreRegisterList_view";
		}
		
	}
		
	//가게 찾기(페이지이동이 안됨)
	@RequestMapping("search")
	//@ResponseBody
	public String search(HttpServletRequest request, Model model) {
		
		System.out.println("컨트롤러 들어옴");
		
		String sLat = request.getParameter("sLat");
		String sLng = request.getParameter("sLng");
		
		ArrayList<StoreDto> str = dao.AdSearch(sLat, sLng);
		
		System.out.println("str : " + str);
		System.out.println("DB갔다옴");
	
		if(str.isEmpty()) {
			System.out.println("목록이 없다.");
			return "NoneStore";
		}
		else {
			System.out.println("목록있음");
			model.addAttribute("searchlist", str);
			return "SearchList_view";
		}

	}
	
	//가게찾기 command 버전
	@RequestMapping("search1")
	//@ResponseBody
	public String search1(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러 들어옴");
		
		command = new SearchCommand();
		command.execute(request, model);
		
		System.out.println("command	: " + command);
		
		return "SearchList_view";

	}
	
	
	@RequestMapping("SearchList")
	public String SearchList() {
		return "SearchList_view";
	}
	
	//가게가 있으면 여기로 이동
	@RequestMapping("storelist")
	public String ok() {
		return "storelist";
	}
	
	//가게없으면 여기로 이동
	@RequestMapping("NoneStore")
	public String NoneStore() {
		return "NoneStore";
	}
	
}

/*
 * 가게등록성공후 가게목록페이지로 이동할수 있게 전체 가게목록리스트 보이는 페이지로 변경
 * 관리자 페이지 만들어서 관리자 로그인 후 가게등록페이지이동하게 만들기 
 */
