package com.yourtoken.yourtokenadmin.service;

import com.yourtoken.yourtokenadmin.model.Otp;

public interface OtpService {
	public void  saveOtp(Otp otp);
	public Otp getOtpObject(String email);
}
