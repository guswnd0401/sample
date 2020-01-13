package com.jung.sample.dao;

import com.jung.sample.dto.JoinDto;

public interface TDao {
	
	public void join(String uId, String uPw, String uName, String uEmail, String uPhone, String uAg1, String uAg2);
	public String IdCheck(JoinDto dto1);

}