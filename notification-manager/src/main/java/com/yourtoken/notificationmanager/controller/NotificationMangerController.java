package com.yourtoken.notificationmanager.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yourtoken.notificationmanager.exception.EmailException;
import com.yourtoken.notificationmanager.exceptionresponse.EmailExceptionResponse;
import com.yourtoken.notificationmanager.models.SimpleMailContent;
import com.yourtoken.notificationmanager.service.SendMailService;


@RestController
public class NotificationMangerController {
	
	private SendMailService sendMailService; 
	
	@Autowired
	public NotificationMangerController(SendMailService sendMailService) {
		super();
		this.sendMailService = sendMailService;
	}

	// a api for test Notification Manager is running or not
	@GetMapping("/test")
	public String test()
	{
		return "notification manager";
	}

	// api for send mail base on simplemailcontent parameters
	@PostMapping("/sendmail")
	public void  sendMail(@RequestBody SimpleMailContent simpleMailContent)
	{
		//first we set SimpleMailMessage object 
		sendMailService.setMessage(simpleMailContent);
		// then we send a mail to user 
		 sendMailService.sendMessage();
	}

	

	@ExceptionHandler
	public ResponseEntity<EmailExceptionResponse> exceptionHandler( EmailException ex)
	{
		EmailExceptionResponse mailError  = new EmailExceptionResponse();
		mailError.setMessage(ex.getMessage());
		mailError.setStatus(HttpStatus.BAD_REQUEST.value());
		mailError.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<EmailExceptionResponse>(mailError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmailExceptionResponse> exceptionHandler(Exception ex)
	{
		EmailExceptionResponse mailError  = new EmailExceptionResponse();
		mailError.setMessage(ex.getMessage());
		mailError.setStatus(HttpStatus.BAD_REQUEST.value());
		mailError.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<EmailExceptionResponse>(mailError, HttpStatus.BAD_REQUEST);
	}
}
