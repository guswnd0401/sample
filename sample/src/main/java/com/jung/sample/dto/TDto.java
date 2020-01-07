package com.jung.sample.dto;

public class TDto {
	
	private String tId;
	private String tPw;
	
	public TDto() {
		super();
	}

	public TDto(String tId, String tPw) {
		super();
		this.tId = tId;
		this.tPw = tPw;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettPw() {
		return tPw;
	}

	public void settPw(String tPw) {
		this.tPw = tPw;
	}	

}