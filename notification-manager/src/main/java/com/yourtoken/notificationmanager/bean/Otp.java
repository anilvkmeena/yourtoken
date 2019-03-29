package com.yourtoken.notificationmanager.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Otp {

	@Id
	private String email;
	private String otp;
	private boolean verfied;
	
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
	public Otp(String email, String otp, boolean verfied) {
		super();
		this.email = email;
		this.otp = otp;
		this.verfied = verfied;
	}
	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Otp [email=" + email + ", otp=" + otp + ", verfied=" + verfied + "]";
	}
	
	
	
	
}
