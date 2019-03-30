package com.yourtoken.notificationmanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.yourtoken.notificationmanager.Utility.DateFormat;
import com.yourtoken.notificationmanager.Utility.NMConstant;

import com.yourtoken.notificationmanager.models.SimpleMailContent;

@Configuration
public class MailBeans {
	
	@Bean
	@ConfigurationProperties("spring.mail")
	public JavaMailSenderImpl mailSenderBean()
	{
		return new JavaMailSenderImpl();
	}
	@Bean
	public SimpleMailMessage simpleMailMessageBean()
	{
		return new SimpleMailMessage();
	}

	@Bean
	public DateFormat dateFormatBeans()
	{
		return new DateFormat();
	}
	
}
