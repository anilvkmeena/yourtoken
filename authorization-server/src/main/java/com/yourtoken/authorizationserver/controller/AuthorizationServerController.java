package com.yourtoken.authorizationserver.controller;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.authorizationserver.beans.AuthorityData;
import com.yourtoken.authorizationserver.beans.UserData;
import com.yourtoken.authorizationserver.dao.UserDataRepositry;
import com.yourtoken.authorizationserver.services.AuthorityService;
import com.yourtoken.authorizationserver.services.UserDataService;

@RestController
public class AuthorizationServerController {

	private UserDataService userDataService;
	private AuthorityService authorityService;
	
	public AuthorizationServerController(UserDataService userDataService, AuthorityService authorityService) {
		super();
		this.userDataService = userDataService;
		this.authorityService = authorityService;
	}

	@GetMapping("/test")
	public UserData test2()
	{
		return new UserData("anil", "pass", true);
		//return "hello auth2";
	}

	@PostMapping("/user")
	public  void saveUserData(@RequestBody UserData userData)
	{
		
		userDataService.saveUser(userData);
	}
	@PostMapping("/authority")
	public void saveUserAuthority(@RequestBody AuthorityData authorityData)
	{
		authorityService.saveUserAuthority(authorityData);
	}
	
}