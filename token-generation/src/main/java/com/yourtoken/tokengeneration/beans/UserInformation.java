package com.yourtoken.tokengeneration.beans;

public class UserInformation {
	private int  id;
	private String  name;
	private String email;
	private String  mobile_no;
	private String discription;
	private String token_number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getToken_number() {
		return token_number;
	}
	public void setToken_number(String token_number) {
		this.token_number = token_number;
	}
	public UserInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInformation(int id, String name, String email, String mobile_no, String discription,
			String token_number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.discription = discription;
		this.token_number = token_number;
	}
	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", name=" + name + ", email=" + email + ", mobile_no=" + mobile_no
				+ ", discription=" + discription + ", token_number=" + token_number + "]";
	}
	
	
	

}
