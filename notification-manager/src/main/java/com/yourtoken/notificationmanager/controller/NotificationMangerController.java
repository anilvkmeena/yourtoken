package com.yourtoken.notificationmanager.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.notificationmanager.bean.SimpleMailContent;
import com.yourtoken.notificationmanager.service.SendMailService;
import com.yourtoken.notificationmanager.serviceimpl.OtpServiceImpl;

@RestController
public class NotificationMangerController {
	
	private SendMailService sendMailService;
	private OtpServiceImpl otpServiceImpl;
	
	@Autowired
	public NotificationMangerController(SendMailService sendMailService, OtpServiceImpl otpServiceImpl) {
		super();
		this.sendMailService = sendMailService;
		this.otpServiceImpl = otpServiceImpl;
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
	//this  api use to verifymail  using otp
	@PostMapping("/verifymail")
	public boolean verifyMail(@RequestParam String email, String otp)
	{
		return otpServiceImpl.VerifyOtp(email, otp);
		
	}
	
	// a api for create and store otp for a user and send user using sendmail api
	@PostMapping("/otp")
	public String OtpGeneration(@RequestParam String email)
	{
		System.out.println(email);
		return otpServiceImpl.GenerationOtpAndSave(email);
	}
	
}
