package com.yourtoken.tokengeneration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.tokengeneration.beans.UserInformation;

//a api for token store token in db
@RestController
@RequestMapping("/token-generation")
public class TokenGenerationController {
	
	@PostMapping("/register-user")
	public void setUserInformation(@RequestBody UserInformation userInformation)
	{
		
		//System.out.println("in hello2");
		System.out.println(userInformation);
	}
	

	
}
