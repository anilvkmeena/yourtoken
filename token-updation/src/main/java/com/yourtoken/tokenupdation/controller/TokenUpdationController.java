package com.yourtoken.tokenupdation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.tokenupdation.beans.TokenStatus;
import com.yourtoken.tokenupdation.service.TokenStatusService;

@RestController
@RequestMapping("/token-updation")
public class TokenUpdationController {

	private TokenStatusService tokenStatusService;
	private TokenStatus tokenStatus=null;
	
	@Autowired
	public TokenUpdationController(TokenStatusService tokenStatusService) {
		super();
		this.tokenStatusService = tokenStatusService;
	}
	@GetMapping("/test")
	public String test()
	{
		return "hello";
	}
	@PostMapping("/update-status/{tokenNumber}")
	public void updateStatus(@PathVariable String tokenNumber)
	{
		
		tokenStatusService.setTokenInQueue(tokenNumber);
		
	}
	
	@PostMapping("/save-status")
	public void saveToken(@RequestBody TokenStatus tokenStatus)
	{
		tokenStatusService.save(tokenStatus);
	}
	@PostMapping("/get-status/{tokenNumber}")
	public TokenStatus getStatus(@PathVariable String tokenNumber )
	{
		
		tokenStatus = tokenStatusService.findById(tokenNumber);
		return tokenStatus;
	}
	
	
}
