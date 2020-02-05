package com.jung.sample.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import com.jung.sample.dto.ApplyDto;
import com.jung.sample.dto.StoreDto;
import com.jung.sample.util.Constant;

@Repository //DAOŬ������ ��Ÿ����  beanŬ������ ��� ������ ��
public class StoreDao implements SDao {
	JdbcTemplate template;
	
	@Autowired  //servlet-context.xml bean bound
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	PlatformTransactionManager transactionManager;
	
	@Autowired 
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	@Autowired
	private SqlSession sqlSession; //field�� autowired
	
	public StoreDao() {
		this.template = Constant.template;
		this.transactionManager = Constant.transactionManager;
	}
	
	//���Ե��
	@Override
	public void Register(String sName, String bName, String bNo, String sImg, String sAd, String sLat, String sLng,
								String sPhone, String sCategory, int sTip, int mPrice, String user_id) {
		
		StoreDto dto = new StoreDto(0, sName, bName, bNo, sImg, sAd, sLat, sLng, sPhone, sCategory, sTip, mPrice, null, user_id);
		sqlSession.insert("register", dto);
		System.out.println("register db���� ����");
		
	}
	
	//���� ����Ʈ
	@Override 
	public ArrayList<StoreDto> Storelist() {
		
		ArrayList<StoreDto> result = (ArrayList) sqlSession.selectList("storelist");
		System.out.println("DB �� : " + result);
		return result;
	}
	
	
	//����ã�� AdSearch()�̸��� selectList(�̸�)�ϰ� mapper id�ϰ� 3������ ��� ���ƾ� �Ѵ�.
	@Override
	public ArrayList<StoreDto> AdSearch(String sLat, String sLng) {
		
		System.out.println("����ã��");
		
		StoreDto dto = new StoreDto(0, null, null, null, null, null, sLat, sLng, null, null, 0, 0, null, null);
		
		ArrayList<StoreDto> result = (ArrayList) sqlSession.selectList("AdSearch", dto);
		System.out.println("DB �� : " + result);
		
		return result;
		
	}
	
	//���� ã�� command���
	@Override
	public ArrayList<StoreDto> Search(String sLat, String sLng) {
		
		System.out.println("����ã��");
		
		StoreDto dto = new StoreDto(0, null, null, null, null, null, sLat, sLng, null, null, 0, 0, null, null);
		
		ArrayList<StoreDto> result = (ArrayList) sqlSession.selectList("Search", dto);
		System.out.println("DB �� : " + result);
		
		return result;
		/*
		String sql = " select * "
				+ "from store"
				+ "where (slat between '"+sLat+"'-0.015 and '"+sLat+"'+0.015) and (slng between '"+sLng+"'-0.015 and '"+sLng+"'+0.015) ";
		
		return (ArrayList<StoreDto>)template.query(sql, 
				new BeanPropertyRowMapper<StoreDto>(StoreDto.class));
		*/
	}

//////////////////////////////////////////////////////////////////////////////
	//�������� ���
	@Override
	public void apply(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory, String user_id) {
		
		ApplyDto dto = new ApplyDto(0, asName, abNo, asLat, asLng, asAd, asPhone, asCategory, null ,user_id);
		
		sqlSession.insert("apply", dto);
		System.out.println("apply db���� ����");
	}
	
	
	//�������� ����Ʈ
	@Override 
	public ArrayList<ApplyDto> applylist() {
		ArrayList<ApplyDto> result = (ArrayList) sqlSession.selectList("applylist");
		System.out.println("DB �� : " + result);
		return result;
	}
	
	//�������� ����ȭ��
	@Override
	public ArrayList<ApplyDto> ApplyContent(int asNo) {
		System.out.println("StoreDao����");
		ArrayList<ApplyDto> result = (ArrayList) sqlSession.selectList("ApplyContent", asNo);
		System.out.println("DB �� : " + result);
		return result;
		
	}
	
	//�������� ����ó��
	@Override
	public void ApplyModify(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory) {
		
		ApplyDto dto = new ApplyDto(0, asName, abNo, asLat, asLng, asAd, asPhone, asCategory, null ,null);
		
		sqlSession.insert("ApplyModify", dto);
		System.out.println("apply db���� ����");
		
	}
}
