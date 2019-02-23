package com.yourtoken.tokengeneration.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_token_details")
public class UserToken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="token_id")
	private int  tokenId;
	@Column(name="token_number")
	private String tokenNumber;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserInformation userInformation;

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	public UserToken(int tokenId, String tokenNumber, UserInformation userInformation) {
		super();
		this.tokenId = tokenId;
		this.tokenNumber = tokenNumber;
		this.userInformation = userInformation;
	}

	public UserToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserToken [tokenId=" + tokenId + ", tokenNumber=" + tokenNumber + ", userInformation=" + userInformation
				+ "]";
	}

	

	
	
}
