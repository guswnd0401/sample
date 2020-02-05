package com.jung.sample.dao;

import java.util.ArrayList;

import com.jung.sample.dto.UserDto;

public interface UDao {
	
	//가입
	public String join(String user_id, String user_pw, String user_name, String user_sex,
							String user_email, String user_phone, String user_profile, String user_ag1, String user_ag2);
	
	//아이디 중복체크
	public String IdCheck(UserDto dto1);
	
	//회원목록
	public ArrayList<UserDto> userlist();

}