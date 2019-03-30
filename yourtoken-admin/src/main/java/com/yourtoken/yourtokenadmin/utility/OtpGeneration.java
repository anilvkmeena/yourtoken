package com.yourtoken.yourtokenadmin.utility;


import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpGeneration {
	
	
	public OtpGeneration() {
		super();
		// TODO Auto-generated constructor stub
	}
	// a method for otp generation basis on otp length
	public int getotp()
	{
		int otpLength = YourTokenAdminConstants.Otp_Length;
		int multiplier;
		int otp;
		multiplier = randomMultiplier(otpLength);
		Random random  =new Random();
		otp = multiplier + random.nextInt(multiplier*9);
		return otp;
	}
	
	public int randomMultiplier(int otpLength )
	{
		int i;
		int multiplier =1;
		for(i=1;i<=otpLength;i++)
		{
			multiplier = multiplier*10;
		}
		return multiplier;
	}

	

}
