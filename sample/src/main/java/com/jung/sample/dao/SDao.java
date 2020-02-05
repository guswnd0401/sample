package com.jung.sample.dao;

import java.util.ArrayList;

import com.jung.sample.dto.ApplyDto;
import com.jung.sample.dto.StoreDto;

public interface SDao {

	//���Ե��
	public void Register(String sName, String bName, String bNo, String sImg, String sAd, String sLat, String sLng,
							String sPhone, String sCategory, int sTip, int mPrice, String user_id);
	
	//���Ը��
	public ArrayList<StoreDto> Storelist();
	
	//����ã��
	public ArrayList<StoreDto> AdSearch(String sLat, String sLng);
	
	//����ã��(command)
	public ArrayList<StoreDto> Search(String sLat, String sLng);
	
	//�������ǵ��
	public void apply(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory, String user_id);
	//�������� ���
	public ArrayList<ApplyDto> applylist();
	
	//�������� ����ȭ��
	public ArrayList<ApplyDto> ApplyContent(int asNo);
	
	//�������� ����
	public void ApplyModify(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory);
	
}
