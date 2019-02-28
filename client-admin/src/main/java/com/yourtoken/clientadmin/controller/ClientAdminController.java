package com.yourtoken.clientadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clien-admin")
public class ClientAdminController {
	
	@GetMapping("/test")
	public String tes() {
		return "client-admin-hello";
	}
	@PostMapping("/create-user")
	public void createUser()
	{
		
	}

	
}
