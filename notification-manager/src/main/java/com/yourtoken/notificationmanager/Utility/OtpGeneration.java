package com.yourtoken.notificationmanager.Utility;


import org.springframework.stereotype.Component;

@Component
public class OtpGeneration {
	
	
	public OtpGeneration() {
		super();
		// TODO Auto-generated constructor stub
	}
	// a method for otp generation
	public int getotp()
	{
		int otpLength = NMConstant.Otp_Length;
		int multiplier;
		int otp;
		multiplier = randomMultiplier(otpLength);
		otp = (int) (Math.random()*multiplier);
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
