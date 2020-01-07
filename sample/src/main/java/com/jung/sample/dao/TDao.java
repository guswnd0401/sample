package com.jung.sample.dao;

import com.jung.sample.dto.JoinDto;
import com.jung.sample.dto.TDto;

public interface TDao {
	
	public void joinDao(String tId, String tPw);
	public String checkId(TDto dto);
	
	public void join(String uId, String uPw, String uName, String uEmail, String uPhone, String uAg1, String uAg2);
	public String IdCheck(JoinDto dto1);

}