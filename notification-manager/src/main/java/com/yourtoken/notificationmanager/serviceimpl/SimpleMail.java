package com.yourtoken.notificationmanager.serviceimpl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.yourtoken.notificationmanager.bean.SimpleMailContent;
import com.yourtoken.notificationmanager.service.SendMailService;

@Service
public class SimpleMail implements SendMailService {

	//private MailSender mailSender;
	private JavaMailSenderImpl mailSender;
    private SimpleMailMessage templateMessage;
	
    @Autowired
	public SimpleMail(JavaMailSenderImpl mailSender, SimpleMailMessage templateMessage) {
		super();
		this.mailSender = mailSender;
		this.templateMessage = templateMessage;
	}

	@Override
	public void setMessage(SimpleMailContent simpleMailContent) {
		// TODO Auto-generated method stub
		templateMessage.setTo(simpleMailContent.getEmailId());
		//templateMessage.setFrom("akumarmeena11@gmail.com");
		templateMessage.setSubject(simpleMailContent.getSubject());
		templateMessage.setText(simpleMailContent.getEmailText());
		
	}

	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
	
		try{
						
			Properties props = mailSender.getJavaMailProperties();
		    props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.debug", "true");
			mailSender.send(templateMessage);
			
		
		}
		catch (MailException ex) {
            // simply log it and go on...
            return ex.getMessage();
        }
		return "your message has been sent";
		
	}

	
	

}
