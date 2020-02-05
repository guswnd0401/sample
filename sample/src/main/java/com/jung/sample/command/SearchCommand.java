package com.jung.sample.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jung.sample.dao.StoreDao;
import com.jung.sample.dto.StoreDto;

public class SearchCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		System.out.println("command ����");
		
		//Map<String, Object> map = model.asMap();
		//Model�� ���������� Map���� �ݷ����̹Ƿ� �Ϲ� Map���� ��ȯ
		//HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		StoreDao dao = new StoreDao();
		
		String sLat = request.getParameter("sLat");
		String sLng = request.getParameter("sLng");
		
		System.out.println("lat : " + sLat);
		System.out.println("lng : " + sLng);

		ArrayList<StoreDto> dto = dao.Search(sLat, sLng);
		
		System.out.println("commanddto : " + dto);
		
		//model.addAttribute("search", dto);
		request.setAttribute("search", dto);
		
		System.out.println("command ����");
	}

}
