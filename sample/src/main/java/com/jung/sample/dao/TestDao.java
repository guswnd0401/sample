package com.jung.sample.dao;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jung.sample.dto.JoinDto;
import com.jung.sample.dto.TDto;


@Repository
public class TestDao implements TDao {
	
	@Autowired
	private SqlSession sqlSession; //field로 autowired
	
	public TestDao() {
		
	}

	@Override
	public void joinDao(String tId, String tPw) {
		
		TDto dto = new TDto(tId, tPw);
		sqlSession.insert("joinDao",dto);
		
	}

	//아이디 중복체크
	@Override
	public String checkId(TDto dto) {
		
		System.out.println("TestDao");
		return sqlSession.selectOne("checkId",dto);
		
	}
	
	//회원가입2
	@Override
	public void join(String uId, String uPw, String uName, String uEmail, String uPhone, String uAg1, String uAg2) {
		JoinDto dto = new JoinDto(uId, uPw, uName, uEmail, uPhone, uAg1, uAg2, null, null);
		sqlSession.insert("join",dto);	
	}

	@Override
	public String IdCheck(JoinDto dto1) {
		
		System.out.println("TestDao1");
		return sqlSession.selectOne("IdCheck",dto1);
		
	}
	

}