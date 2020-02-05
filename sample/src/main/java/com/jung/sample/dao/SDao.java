package com.jung.sample.dao;

import java.util.ArrayList;

import com.jung.sample.dto.ApplyDto;
import com.jung.sample.dto.StoreDto;

public interface SDao {

	//가게등록
	public void Register(String sName, String bName, String bNo, String sImg, String sAd, String sLat, String sLng,
							String sPhone, String sCategory, int sTip, int mPrice, String user_id);
	
	//가게목록
	public ArrayList<StoreDto> Storelist();
	
	//가게찾기
	public ArrayList<StoreDto> AdSearch(String sLat, String sLng);
	
	//가게찾기(command)
	public ArrayList<StoreDto> Search(String sLat, String sLng);
	
	//입점문의등록
	public void apply(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory, String user_id);
	//입점문의 목록
	public ArrayList<ApplyDto> applylist();
	
	//입점문의 수정화면
	public ArrayList<ApplyDto> ApplyContent(int asNo);
	
	//입점문의 수정
	public void ApplyModify(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory);
	
}
