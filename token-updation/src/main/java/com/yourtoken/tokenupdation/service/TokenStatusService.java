package com.yourtoken.tokenupdation.service;

import com.yourtoken.tokenupdation.beans.TokenStatus;

public interface TokenStatusService {
	public void save(TokenStatus tokenStatus);
	public TokenStatus findById(String tokenNumber);
	//public void updateTokenStatus(String tokenNumber);
	public void setTokenInQueue(String tokenNumber);
}
