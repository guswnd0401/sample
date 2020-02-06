package com.jung.sample.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jung.sample.dto.UserDto;

//mybatis����� ���ؼ��� SqlSessionŬ������ �̿���
@Repository //DAOŬ������ ��Ÿ����  beanŬ������ ��� ������ ��
//(@Controller,@Service�� CommandŬ����,@Repository�� DaoŬ����)
public class UserDao implements UDao {
	
	JdbcTemplate template;
	
	@Autowired
	private SqlSession sqlSession; //field�� autowired
	
	public UserDao() {	
	}

	//ȸ������
	@Override
	public String join(String user_id, String user_pw, String user_name, String user_sex,
			String user_email, String user_phone, String user_profile, String user_ag1, String user_ag2) {
		
		UserDto dto = new UserDto(user_id, user_pw, user_name, user_sex, user_email, user_phone, 
															user_profile, user_ag1, user_ag2, null, null);
		
		System.out.println("���� ����1");
		
		int result;
		
		result = sqlSession.insert("signup",dto);
		System.out.println("result : " + result);
		
		if(result > 0)	{ //1�̸� ���Լ���
			return "join-success";
		}
		else {
			return "join-failed";
		}
		
	}
	
	//ȸ������Ʈ
	@Override 
	public ArrayList<UserDto> userlist() {
		ArrayList<UserDto> result = (ArrayList) sqlSession.selectList("userlist");
		System.out.println("DB �� : " + result);
		return result;
	}

	//���̵� �ߺ�üũ
	@Override
	public String IdCheck(UserDto dto1) {
		System.out.println("���̵� �ߺ� üũ");
		return sqlSession.selectOne("IdCheck",dto1);
	}
	
	//�α��� ��ť��Ƽ
	public UserDto login(String username) {		

		System.out.println("dao �α��� �Է°� : " + username);
		
		String sql = "SELECT USER_ID, USERPW, USER_NAME, USER_SEX, USER_EMAIL, USER_PHONE, USER_AG1, USER_AG2, USER_CODE, USER_DATE"
				+ " FROM USER_INFO WHERE USER_ID='"+ username +"'";
		System.out.println(sql);
		
		UserDto uId = template.queryForObject(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));
		
		
		System.out.println(uId);
		System.out.println("sql ��� �� PW : " + uId.getUser_pw());
		
		/*
		System.out.println("==================");
		UserDto dto = sqlSession.selectOne("login",userid);
		System.out.println("dot : " + dto);
		*/
		return uId;	
		
	}
}