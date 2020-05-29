package com.bean;

public class UserBean {

	private int uId;
	private String uName;
	private String uEmail;
	private String uPassword;
	private int uAge;
	private int cityId;
	
	

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public int getuAge() {
		return uAge;
	}

	public void setuAge(int uAge) {
		this.uAge = uAge;
	}

}
