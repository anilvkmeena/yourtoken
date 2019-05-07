package com.yourtoken.yourtokenadmin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourtoken.yourtokenadmin.exception.YtAdminException;
import com.yourtoken.yourtokenadmin.exceptionresponse.ExceptionResponse;
import com.yourtoken.yourtokenadmin.model.ClientAdmin;
import com.yourtoken.yourtokenadmin.service.ClientAdminService;
import com.yourtoken.yourtokenadmin.serviceimpl.OtpServiceImpl;


@RestController
@RequestMapping
public class YourTokenAdminController {

	private ClientAdminService clientAdminService;
	private ClientAdmin clientAdmin = null;
	private OtpServiceImpl otpServiceImpl;
	
	
	@Autowired
	public YourTokenAdminController(ClientAdminService clientAdminService,OtpServiceImpl otpServiceImpl ) {
		super();	
		this.clientAdminService = clientAdminService;
		this.otpServiceImpl = otpServiceImpl;
	}

	
	
	@GetMapping("/test")
	public String  test()
	{
		return  "hello Admin";
	}
	//request for  create new client
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
	
	// a api for create and store otp for a user and call sendmail api of notification manager
	@PostMapping("/otp")
	public void OtpGeneration(@RequestParam String emailId)
	{
		 otpServiceImpl.GenerationOtpAndSave(emailId);
	}
	
	//this  api use to verifymail  using otp
	@PostMapping("/verifymail")
	public void verifyMail(@RequestParam String emailId, String otp)
	{
		otpServiceImpl.VerifyOtp(emailId, otp);
		
	}
	
	

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> exceptionHandler(YtAdminException ex)
	{
		ExceptionResponse mailError  = new ExceptionResponse();
		mailError.setMessage(ex.getMessage());
		mailError.setStatus(HttpStatus.BAD_REQUEST.value());
		mailError.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExceptionResponse>(mailError, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex)
	{
		ExceptionResponse mailError  = new ExceptionResponse();
		mailError.setMessage(ex.getMessage());
		mailError.setStatus(HttpStatus.BAD_REQUEST.value());
		mailError.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExceptionResponse>(mailError, HttpStatus.BAD_REQUEST);
	}
	
	
	

	

	

}
