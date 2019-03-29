package com.yourtoken.notificationmanager.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yourtoken.notificationmanager.bean.SimpleMailContent;

@Component
public class NotificationMessage {
	
	private SimpleMailContent simpleMailContent=null;
	
	

	
	public NotificationMessage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SimpleMailContent otpsendMessage(String emailId,String otp)
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
