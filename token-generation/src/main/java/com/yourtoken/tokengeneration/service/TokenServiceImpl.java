package com.yourtoken.tokengeneration.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.yourtoken.tokengeneration.beans.UserToken;
import com.yourtoken.tokengeneration.dao.TokenRepositry;

public class TokenServiceImpl implements TokenService {

	private TokenRepositry tokenRepositry;
	
	@Autowired
	public TokenServiceImpl(TokenRepositry tokenRepositry) {
		super();
		this.tokenRepositry = tokenRepositry;
	}


	@Override
	public void save(UserToken userToken) {
		// TODO Auto-generated method stub
		tokenRepositry.save(userToken);
		
	}

}
