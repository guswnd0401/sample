package com.jung.sample.dao;

import org.apache.ibatis.session.SqlSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jung.sample.dto.JoinDto;

@Repository
public class TestDao implements TDao {
	
	JdbcTemplate template;
	
	@Autowired
	private SqlSession sqlSession; //field로 autowired
	
	public TestDao() {
		
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
	
	public JoinDto login(String username) {		
		System.out.println(username);
		String sql = "SELECT USERID,USERPW,USERNAME,USEREMAIL,USERPHONE,USERCODE,USERDATE FROM USERINFO WHERE USERID='"+ username +"'";
		System.out.println(sql);
		JoinDto uId = template.queryForObject(sql, new BeanPropertyRowMapper<JoinDto>(JoinDto.class));
		System.out.println(uId);
		System.out.println(uId.getuPw());
		
		return uId;		
	}

}