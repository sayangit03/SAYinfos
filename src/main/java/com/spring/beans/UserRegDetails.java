package com.spring.beans;

import java.util.Date;

public class UserRegDetails {
	
	private int id;
	private String userName;
	private String userPhnNum;
	private String userEmail;
	private String userAdrs;
	private String userStatus;
	private Date regDate;
	
	private String userRole;


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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
