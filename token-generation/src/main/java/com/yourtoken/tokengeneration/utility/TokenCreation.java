package com.yourtoken.tokengeneration.utility;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yourtoken.tokengeneration.beans.UserInformation;
import com.yourtoken.tokengeneration.beans.UserToken;
import com.yourtoken.tokengeneration.service.UserInformationService;

@Component
public class TokenCreation {
	
	
	private UserInformationService userInformationService;
	private UserToken userToken =  new UserToken();
	private UserInformation userInformation=null;
	
	@Autowired
	public TokenCreation( UserInformationService userInformationService) {
		super();
		this.userInformationService = userInformationService;
	}



	public  UserToken createToken(String userId)
	{
		
		String companyId = userId.substring(0, 4);
		String company_code  = "AB";
		String token_key = company_code+"1234";
		int id = Integer.parseInt((userId));
		userInformation=userInformationService.findById(id);
		userToken.setTokenNumber(token_key);
		userToken.setUserInformation(userInformation);		
		return userToken;
	}
	
}
