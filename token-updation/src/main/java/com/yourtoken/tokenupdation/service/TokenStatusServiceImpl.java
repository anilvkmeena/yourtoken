package com.yourtoken.tokenupdation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourtoken.tokenupdation.beans.TokenStatus;
import com.yourtoken.tokenupdation.dao.TokenStatusRepositry;

@Service
public class TokenStatusServiceImpl implements TokenStatusService {

	private TokenStatusRepositry tokenStatusRepositry;
	
	
	@Autowired
	public TokenStatusServiceImpl(TokenStatusRepositry tokenStatusRepo) {
		super();
		tokenStatusRepositry = tokenStatusRepo;
	}

	@Override
	public void save(TokenStatus tokenStatus) {
		tokenStatusRepositry.save(tokenStatus);

	}

	@Override
	public TokenStatus findById(String tokenNumber) {
		// TODO Auto-generated method stub
		TokenStatus tokenStatus=null;
		Optional<TokenStatus> result  = tokenStatusRepositry.findById(tokenNumber);
		if(result.isPresent()) 
		{
			tokenStatus = result.get();
		}
		else
		{
			throw new RuntimeException("user not found with id: "+tokenNumber);
		}
		return tokenStatus;

	}

	@Override
	public void setTokenInQueue(String tokenNumber) {
		// TODO Auto-generated method stub
		tokenStatusRepositry.setTokenInQueue(tokenNumber,"NO");
		
	}

	

	
	

}
