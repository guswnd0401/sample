package com.jung.sample.dto;

import java.sql.Timestamp;

public class JoinDto {
	
	private String uId;
	private String uPw;
	private String uName;
	private String uEmail;
	private String uPhone;
	private String uAg1;
	private String uAg2;
	private Timestamp uDate;
	private String uCode;
	
	public JoinDto() {
		super();
	}

	public JoinDto(String uId, String uPw, String uName, String uEmail, String uPhone, String uAg1, String uAg2,
			Timestamp uDate, String uCode) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uAg1 = uAg1;
		this.uAg2 = uAg2;
		this.uDate = uDate;
		this.uCode = uCode;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuAg1() {
		return uAg1;
	}

	public void setuAg1(String uAg1) {
		this.uAg1 = uAg1;
	}

	public String getuAg2() {
		return uAg2;
	}

	public void setuAg2(String uAg2) {
		this.uAg2 = uAg2;
	}

	public Timestamp getuDate() {
		return uDate;
	}

	public void setuDate(Timestamp uDate) {
		this.uDate = uDate;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

}