package com.jung.sample.dao;

import java.util.ArrayList;

import com.jung.sample.dto.UserDto;

public interface UDao {
	
	//����
	public String join(String user_id, String user_pw, String user_name, String user_sex,
							String user_email, String user_phone, String user_profile, String user_ag1, String user_ag2);
	
	//���̵� �ߺ�üũ
	public String IdCheck(UserDto dto1);
	
	//ȸ�����
	public ArrayList<UserDto> userlist();

}