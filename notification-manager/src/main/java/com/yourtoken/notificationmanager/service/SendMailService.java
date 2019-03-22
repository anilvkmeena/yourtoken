package com.yourtoken.notificationmanager.service;

import com.yourtoken.notificationmanager.bean.SimpleMailContent;

public interface SendMailService {
	
	public void setMessage(SimpleMailContent simpleMailContent);
	public String sendMessage();
	

}
