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
	
	//���Ե��
	@RequestMapping("register")
	public String register(MultipartHttpServletRequest request, Model model) {
		
		//===========================
		
		MultipartFile mf = request.getFile("sImg");
		//MultipartFile��ü�� ��, �̋��� getParameter��� getFile()�޼��带 ���
		System.out.println(mf);
		
		String path = "D:/TeamProject/Store/";
		//������ ���޵� �����̸�
		String originFileName = mf.getOriginalFilename();
		//���ε�� ���� ũ��
		long fileSize = mf.getSize();
		
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);		
		
		//������ ������ �̸��� �ٲپ� ����(������ �̸��� ������ ������ �ߺ� ����, �ð��� �տ� �ٿ� �ߺ� ����)
		String safeFile = path + System.currentTimeMillis() + originFileName;
		String dfile = System.currentTimeMillis() + originFileName;
				
		try {
			mf.transferTo(new File(safeFile)); //MultipartFile��ü�� �Ϲ� ���� ��ü�� ��ȯ
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
		
		System.out.println("��� ����");		
		return "redirect:StoreList";
		
	}
	
	//���� ����Ʈ
	@RequestMapping("StoreList")
	public String StoreList(Model model) {
		
		ArrayList<StoreDto> str = dao.Storelist();
		System.out.println("dao : " + dao.Storelist());
		System.out.println("str : " + str);
		
		if(str.isEmpty()) {
			System.out.println("����� ����.");
			return "NoneStore";
		}
		else {
			System.out.println("�������");
			model.addAttribute("storelist", str);
			return "StoreRegisterList_view";
		}
		
	}
		
	//���� ã��(�������̵��� �ȵ�)
	@RequestMapping("search")
	//@ResponseBody
	public String search(HttpServletRequest request, Model model) {
		
		System.out.println("��Ʈ�ѷ� ����");
		
		String sLat = request.getParameter("sLat");
		String sLng = request.getParameter("sLng");
		
		ArrayList<StoreDto> str = dao.AdSearch(sLat, sLng);
		
		System.out.println("str : " + str);
		System.out.println("DB���ٿ�");
	
		if(str.isEmpty()) {
			System.out.println("����� ����.");
			return "NoneStore";
		}
		else {
			System.out.println("�������");
			model.addAttribute("searchlist", str);
			return "SearchList_view";
		}

	}
	
	//����ã�� command ����
	@RequestMapping("search1")
	//@ResponseBody
	public String search1(HttpServletRequest request, Model model) {
		System.out.println("��Ʈ�ѷ� ����");
		
		command = new SearchCommand();
		command.execute(request, model);
		
		System.out.println("command	: " + command);
		
		return "SearchList_view";

	}
	
	
	@RequestMapping("SearchList")
	public String SearchList() {
		return "SearchList_view";
	}
	
	//���԰� ������ ����� �̵�
	@RequestMapping("storelist")
	public String ok() {
		return "storelist";
	}
	
	//���Ծ����� ����� �̵�
	@RequestMapping("NoneStore")
	public String NoneStore() {
		return "NoneStore";
	}
	
}

/*
 * ���Ե�ϼ����� ���Ը���������� �̵��Ҽ� �ְ� ��ü ���Ը�ϸ���Ʈ ���̴� �������� ����
 * ������ ������ ���� ������ �α��� �� ���Ե���������̵��ϰ� ����� 
 */
