package com.yourtoken.tokenupdation.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TokenStatus {
	
	@Id
	private String tokenNumber;
	private String tokenInQueue;
	private String tokenCreationTime;
	private String tokenEstimateProcessTime;
	public String getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	public String getTokenInQueue() {
		return tokenInQueue;
	}
	public void setTokenInQueue(String tokenInQueue) {
		this.tokenInQueue = tokenInQueue;
	}
	public String getTokenCreationTime() {
		return tokenCreationTime;
	}
	public void setTokenCreationTime(String tokenCreationTime) {
		this.tokenCreationTime = tokenCreationTime;
	}
	public String getTokenEstimateProcessTime() {
		return tokenEstimateProcessTime;
	}
	public void setTokenEstimateProcessTime(String tokenEstimateProcessTime) {
		this.tokenEstimateProcessTime = tokenEstimateProcessTime;
	}
	public TokenStatus(String tokenNumber, String tokenInQueue, String tokenCreationTime,
			String tokenEstimateProcessTime) {
		super();
		this.tokenNumber = tokenNumber;
		this.tokenInQueue = tokenInQueue;
		this.tokenCreationTime = tokenCreationTime;
		this.tokenEstimateProcessTime = tokenEstimateProcessTime;
	}
	public TokenStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TokenStatus [tokenNumber=" + tokenNumber + ", tokenInQueue=" + tokenInQueue + ", tokenCreationTime="
				+ tokenCreationTime + ", tokenEstimateProcessTime=" + tokenEstimateProcessTime + "]";
	}
	
	
	
	

}
