package com.yourtoken.yourtokenadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientAdmin {
	@Id
	private int clientId;
	private String clientName;
	private String clientEmail;
	private String mobileNumber;
	private String accountType;
	private String createdDate;
	private String updaedDate;
	private boolean verified;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdaedDate() {
		return updaedDate;
	}
	public void setUpdaedDate(String updaedDate) {
		this.updaedDate = updaedDate;
	}
	public ClientAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
	
	


}
