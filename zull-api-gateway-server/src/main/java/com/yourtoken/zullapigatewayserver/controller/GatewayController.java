package com.yourtoken.zullapigatewayserver.controller;

/*import org.springframework.security.core.Authentication;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
	
	@GetMapping("/test")
	public String  test()
	{
		return "hello gateway4";
	}
	
	@GetMapping("/login")
	public String validateUser()
	{
		return "hello user88";
	}
	/*@GetMapping("/access-denied")
	public String accessDenied(Authentication authentication)
	{
		
		return "not-allow"+authentication.getAuthorities()+authentication.getName()+"yes";
	}*/
	
	
}
