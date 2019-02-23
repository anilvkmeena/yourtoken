package com.yourtoken.tokengeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.tokengeneration.beans.UserInformation;
import com.yourtoken.tokengeneration.dao.TokenRepositry;
import com.yourtoken.tokengeneration.dao.UserRepositry;
import com.yourtoken.tokengeneration.service.UserInformationService;
import com.yourtoken.tokengeneration.utility.TokenCreation;


@RestController
@RequestMapping("/token-generation")
public class TokenGenerationController {
	
	private UserInformationService userInformationService;
	private TokenRepositry tokenRepositry;
	private TokenCreation tokenCreation;
	
	@Autowired
	public TokenGenerationController(
			UserInformationService userInformationService,
			TokenCreation tokenCreation,TokenRepositry tokenRepositry) {
		
		super();
		this.userInformationService = userInformationService;
		this.tokenCreation = tokenCreation;
		this.tokenRepositry=tokenRepositry;
		
	}

	@PostMapping("/register-user")
	public void setUserInformation(@RequestBody UserInformation userInformation)
	{
		userInformationService.save(userInformation);	
	
	}
	
	@PostMapping("/generate-token/{userId}")
	public void generateToken(@PathVariable String userId)
	{
		//String userId ="12345678";
		System.out.println("yesssssssssssssssssssssssssssss"+userId);
		tokenRepositry.save(tokenCreation.createToken(userId));
		
	}

	
}
