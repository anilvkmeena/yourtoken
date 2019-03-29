package com.yourtoken.notificationmanager.service;

import com.yourtoken.notificationmanager.bean.Otp;

public interface OtpService {
	public void  saveOtp(Otp otp);
	public void getOtp(String email);
	
	

}
