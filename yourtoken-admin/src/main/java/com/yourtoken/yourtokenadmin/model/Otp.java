package com.yourtoken.yourtokenadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

//a entity class for store OTP in database 
@Entity
public class Otp {

	@Id
	private String email;
	private String otp;
	private boolean verfied;
	private String createdDate;
	private String updatedDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public boolean isVerfied() {
		return verfied;
	}
	public void setVerfied(boolean verfied) {
		this.verfied = verfied;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Otp(String email, String otp, boolean verfied, String createdDate, String updatedDate) {
		super();
		this.email = email;
		this.otp = otp;
		this.verfied = verfied;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
	
	
}
