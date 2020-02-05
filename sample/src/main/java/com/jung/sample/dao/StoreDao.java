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

@Repository //DAO클래스를 나타내며  bean클래스로 사용 가능케 함
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
	private SqlSession sqlSession; //field로 autowired
	
	public StoreDao() {
		this.template = Constant.template;
		this.transactionManager = Constant.transactionManager;
	}
	
	//가게등록
	@Override
	public void Register(String sName, String bName, String bNo, String sImg, String sAd, String sLat, String sLng,
								String sPhone, String sCategory, int sTip, int mPrice, String user_id) {
		
		StoreDto dto = new StoreDto(0, sName, bName, bNo, sImg, sAd, sLat, sLng, sPhone, sCategory, sTip, mPrice, null, user_id);
		sqlSession.insert("register", dto);
		System.out.println("register db삽입 성공");
		
	}
	
	//가게 리스트
	@Override 
	public ArrayList<StoreDto> Storelist() {
		
		ArrayList<StoreDto> result = (ArrayList) sqlSession.selectList("storelist");
		System.out.println("DB 값 : " + result);
		return result;
	}
	
	
	//가게찾기 AdSearch()이름과 selectList(이름)하고 mapper id하고 3가지가 모두 같아야 한다.
	@Override
	public ArrayList<StoreDto> AdSearch(String sLat, String sLng) {
		
		System.out.println("가게찾기");
		
		StoreDto dto = new StoreDto(0, null, null, null, null, null, sLat, sLng, null, null, 0, 0, null, null);
		
		ArrayList<StoreDto> result = (ArrayList) sqlSession.selectList("AdSearch", dto);
		System.out.println("DB 값 : " + result);
		
		return result;
		
	}
	
	//가게 찾기 command사용
	@Override
	public ArrayList<StoreDto> Search(String sLat, String sLng) {
		
		System.out.println("가게찾기");
		
		StoreDto dto = new StoreDto(0, null, null, null, null, null, sLat, sLng, null, null, 0, 0, null, null);
		
		ArrayList<StoreDto> result = (ArrayList) sqlSession.selectList("Search", dto);
		System.out.println("DB 값 : " + result);
		
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
	//입점문의 등록
	@Override
	public void apply(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory, String user_id) {
		
		ApplyDto dto = new ApplyDto(0, asName, abNo, asLat, asLng, asAd, asPhone, asCategory, null ,user_id);
		
		sqlSession.insert("apply", dto);
		System.out.println("apply db삽입 성공");
	}
	
	
	//입점문의 리스트
	@Override 
	public ArrayList<ApplyDto> applylist() {
		ArrayList<ApplyDto> result = (ArrayList) sqlSession.selectList("applylist");
		System.out.println("DB 값 : " + result);
		return result;
	}
	
	//입점문의 수정화면
	@Override
	public ArrayList<ApplyDto> ApplyContent(int asNo) {
		System.out.println("StoreDao들어옴");
		ArrayList<ApplyDto> result = (ArrayList) sqlSession.selectList("ApplyContent", asNo);
		System.out.println("DB 값 : " + result);
		return result;
		
	}
	
	//입점문의 수정처리
	@Override
	public void ApplyModify(String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory) {
		
		ApplyDto dto = new ApplyDto(0, asName, abNo, asLat, asLng, asAd, asPhone, asCategory, null ,null);
		
		sqlSession.insert("ApplyModify", dto);
		System.out.println("apply db삽입 성공");
		
	}
}
