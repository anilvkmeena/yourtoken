package com.yourtoken.notificationmanager.service;

import com.yourtoken.notificationmanager.models.SimpleMailContent;


public interface SendMailService {
	
	public void setMessage(SimpleMailContent simpleMailContent);
	public void sendMessage();
	

}