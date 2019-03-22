package com.yourtoken.notificationmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.notificationmanager.bean.SimpleMailContent;
import com.yourtoken.notificationmanager.service.SendMailService;

@RestController
public class NotificationMangerController {
	
	private SendMailService sendMailService;
	
	@Autowired
	public NotificationMangerController(SendMailService sendMailService) {
		super();
		this.sendMailService = sendMailService;
	}

	@GetMapping("/test")
	public String test()
	{
		return "notification manager";
	}

	@PostMapping("/sendmail")
	public String  sendMail(@RequestBody SimpleMailContent simpleMailContent)
	{
		sendMailService.setMessage(simpleMailContent);
		return sendMailService.sendMessage();
	}
	
	
}
