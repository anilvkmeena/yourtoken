package com.yourtoken.tokengeneration.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="UserInformation")
public class UserInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private String  name;
	
	private String email;
	
	@Column(name = "mobile_number")
	private String  mobileNumber;
	
	private String discription;

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public UserInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInformation(int id, String name, String email, String mobileNumber, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", discription=" + discription + "]";
	}
	
	
	
	
	
	
	
	

}
