package com.yourtoken.yourtokenadmin.utility;

import org.springframework.stereotype.Component;

import com.yourtoken.yourtokenadmin.model.SimpleMailContent;


// this class have diffrent type method which are template different type message on Demand
@Component
public class NotificationMessage {
	
	private SimpleMailContent simpleMailContent=null;
	public NotificationMessage() {
		super();
		// TODO Auto-generated constructor stub
	}


	//message for in case when we send otp to user
	public SimpleMailContent otpMessage(String emailId,String otp)
	{
		simpleMailContent = new SimpleMailContent();
		String emailText  ="To verify your identity, please use the following code:\r\n" + 
				"\r\n" + 
				otp + 
				"\r\n" + 
				"This OTP is confidential. For security reasons, DO NOT share the OTP with anyone. ";
		simpleMailContent.setEmailId(emailId);
		simpleMailContent.setEmailText(emailText);
		simpleMailContent.setSubject("YourToken OTP");
		return simpleMailContent;
		
	}

}
