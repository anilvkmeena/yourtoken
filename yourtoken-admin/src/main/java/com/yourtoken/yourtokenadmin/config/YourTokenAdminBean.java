package com.yourtoken.yourtokenadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yourtoken.yourtokenadmin.utility.DateFormat;
import com.yourtoken.yourtokenadmin.utility.NotificationMessage;
import com.yourtoken.yourtokenadmin.utility.OtpGeneration;


@Configuration
public class YourTokenAdminBean {
	
	@Bean
	public DateFormat dateFormatBeans()
	{
		return new DateFormat();
	}
	@Bean
	public OtpGeneration otpGenerationBean()
	{
		return new OtpGeneration();
		
	}
	@Bean
	public NotificationMessage notificationMessageBean()
	{
		return new NotificationMessage();
	}
}
