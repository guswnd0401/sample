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
		System.out.println("command 들어옴");
		
		//Map<String, Object> map = model.asMap();
		//Model은 스프링제공 Map형태 콜렉션이므로 일반 Map으로 변환
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
		
		System.out.println("command 나감");
	}

}
