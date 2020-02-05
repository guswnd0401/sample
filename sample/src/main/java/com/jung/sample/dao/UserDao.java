package com.jung.sample.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jung.sample.dto.UserDto;

//mybatis사용을 위해서는 SqlSession클래스를 이용함
@Repository //DAO클래스를 나타내며  bean클래스로 사용 가능케 함
//(@Controller,@Service는 Command클래스,@Repository는 Dao클래스)
public class UserDao implements UDao {
	
	JdbcTemplate template;
	
	@Autowired
	private SqlSession sqlSession; //field로 autowired
	
	public UserDao() {	
	}

	//회원가입
	@Override
	public String join(String user_id, String user_pw, String user_name, String user_sex,
			String user_email, String user_phone, String user_profile, String user_ag1, String user_ag2) {
		
		UserDto dto = new UserDto(user_id, user_pw, user_name, user_sex, user_email, user_phone, 
															user_profile, user_ag1, user_ag2, null, null);
		
		System.out.println("가입 시작1");
		
		int result;
		
		result = sqlSession.insert("signup",dto);
		System.out.println("result : " + result);
		
		if(result > 0)	{ //1이면 가입성공
			return "join-success";
		}
		else {
			return "join-failed";
		}
		
	}
	
	//회원리스트
	@Override 
	public ArrayList<UserDto> userlist() {
		ArrayList<UserDto> result = (ArrayList) sqlSession.selectList("userlist");
		System.out.println("DB 값 : " + result);
		return result;
	}

	//아이디 중복체크
	@Override
	public String IdCheck(UserDto dto1) {
		System.out.println("아이디 중복 체크");
		return sqlSession.selectOne("IdCheck",dto1);
	}
	
	//로그인 시큐리티
	public UserDto login(String username) {		

		System.out.println(username);
		
		String sql = "SELECT USER_ID, USERPW, USER_NAME, USER_SEX, USER_EMAIL, USER_PHONE, USER_AG1, USER_AG2, USER_CODE, USER_DATE"
				+ " FROM USER_INFO WHERE USER_ID='"+ username +"'";
		System.out.println(sql);
		
		UserDto uId = template.queryForObject(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));
		
		
		System.out.println(uId);
		System.out.println(uId.getUser_pw());
		
		/*
		System.out.println("==================");
		UserDto dto = sqlSession.selectOne("login",userid);
		System.out.println("dot : " + dto);
		*/
		return uId;	
		
	}
}