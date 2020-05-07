package com.spring.beans;

public class UserDetails {
	
	private int id;
	
	private String userPhnNum;
	
	private String userEmail;
	
	private String userAdrs;
	
	private UserLogin login;
	
	public UserDetails() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserPhnNum() {
		return userPhnNum;
	}

	public void setUserPhnNum(String userPhnNum) {
		this.userPhnNum = userPhnNum;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserAdrs() {
		return userAdrs;
	}

	public void setUserAdrs(String userAdrs) {
		this.userAdrs = userAdrs;
	}

	public UserLogin getLogin() {
		return login;
	}

	public void setLogin(UserLogin login) {
		this.login = login;
	}
}
