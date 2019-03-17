package com.yourtoken.yourtokenadmin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.yourtokenadmin.beans.ClientAdmin;
import com.yourtoken.yourtokenadmin.service.ClientAdminService;


@RestController
@RequestMapping
public class YourTokenAdminController {

	private ClientAdminService clientAdminService;
	private ClientAdmin clientAdmin = null;
	
	@Autowired
	public YourTokenAdminController(ClientAdminService clientAdminService) {
		super();
		
		this.clientAdminService = clientAdminService;
	}

	@GetMapping("/test")
	public String  test()
	{
		return  "hello Admin";
	}
	
	@PostMapping("client")
	public void  registerClient(@RequestBody ClientAdmin clientAdmin)
	{
		clientAdminService.saveClient(clientAdmin);
	}

	@GetMapping("/client/{clientId}")
	public ClientAdmin getClient(@PathVariable int clientId)
	{
		clientAdmin=clientAdminService.findClient(clientId);
		return clientAdmin;
	}


	

}
