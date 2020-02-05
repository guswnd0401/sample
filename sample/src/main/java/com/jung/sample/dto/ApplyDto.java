package com.jung.sample.dto;

import java.sql.Timestamp;

public class ApplyDto {//사장페이지에서 가게요청페이지 값(가게요청게시판 리스트 dto는 UserDto항목이랑 합쳐서 다시만들어야함)
	
	private int asNo;
	private String asName; 
	private String abNo;
	private String asLat;
	private String asLng;
	private String asAd;
	private String asPhone;
	private String asCategory;
	private Timestamp asDate;
	private String user_id;
	
	public ApplyDto() {
		super();
	}

	public ApplyDto(int asNo, String asName, String abNo, String asLat, String asLng, String asAd, String asPhone,
			String asCategory, Timestamp asDate, String user_id) {
		super();
		this.asNo = asNo;
		this.asName = asName;
		this.abNo = abNo;
		this.asLat = asLat;
		this.asLng = asLng;
		this.asAd = asAd;
		this.asPhone = asPhone;
		this.asCategory = asCategory;
		this.asDate = asDate;
		this.user_id = user_id;
	}

	public int getAsNo() {
		return asNo;
	}

	public void setAsNo(int asNo) {
		this.asNo = asNo;
	}

	public String getAsName() {
		return asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public String getAbNo() {
		return abNo;
	}

	public void setAbNo(String abNo) {
		this.abNo = abNo;
	}

	public String getAsLat() {
		return asLat;
	}

	public void setAsLat(String asLat) {
		this.asLat = asLat;
	}

	public String getAsLng() {
		return asLng;
	}

	public void setAsLng(String asLng) {
		this.asLng = asLng;
	}

	public String getAsAd() {
		return asAd;
	}

	public void setAsAd(String asAd) {
		this.asAd = asAd;
	}

	public String getAsPhone() {
		return asPhone;
	}

	public void setAsPhone(String asPhone) {
		this.asPhone = asPhone;
	}

	public String getAsCategory() {
		return asCategory;
	}

	public void setAsCategory(String asCategory) {
		this.asCategory = asCategory;
	}

	public Timestamp getAsDate() {
		return asDate;
	}

	public void setAsDate(Timestamp asDate) {
		this.asDate = asDate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	

}
