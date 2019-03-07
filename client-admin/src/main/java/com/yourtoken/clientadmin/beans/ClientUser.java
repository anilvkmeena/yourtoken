package com.yourtoken.clientadmin.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class ClientUser {
	@Id
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userType;
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public ClientUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientUser(int userId, String userName, String userEmail, String userPassword, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "ClientUser [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userType=" + userType + "]";
	}
	
	

}
