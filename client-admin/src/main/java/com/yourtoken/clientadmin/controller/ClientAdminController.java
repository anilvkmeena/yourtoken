package com.yourtoken.clientadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yourtoken.clientadmin.beans.ClientUser;
import com.yourtoken.clientadmin.service.ClientUserService;

@RestController
@RequestMapping("/client-admin")
public class ClientAdminController {
	
	private ClientUserService clientUserService;
	private ClientUser clientUser;
	
	public ClientAdminController(ClientUserService clientUserService) {
		super();
		this.clientUserService = clientUserService;
	}
	@GetMapping("/test")
	public String tes() {
		return "client-admin-hello";
	}
	@PostMapping("/create-user")
	public void createUser(@RequestBody ClientUser clientUser)
	{
		clientUserService.saveClientUser(clientUser);
	}
	@PostMapping("/get-user/{userId}")
	public ClientUser getUser(@PathVariable int userId)
	{
		
		clientUser = clientUserService.getUser(userId);
		return clientUser;
	}

	
}
