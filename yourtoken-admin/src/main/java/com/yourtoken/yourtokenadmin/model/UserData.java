package com.yourtoken.yourtokenadmin.model;




public class UserData {
	private String userName;
	private String password;
	private boolean enabled;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
