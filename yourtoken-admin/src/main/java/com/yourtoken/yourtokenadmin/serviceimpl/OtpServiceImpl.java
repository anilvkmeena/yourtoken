package com.yourtoken.yourtokenadmin.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourtoken.yourtokenadmin.dao.OtpRepositry;
import com.yourtoken.yourtokenadmin.exception.YtAdminException;
import com.yourtoken.yourtokenadmin.feignproxy.NotificationManagerFeginProxy;
import com.yourtoken.yourtokenadmin.model.Otp;
import com.yourtoken.yourtokenadmin.model.SimpleMailContent;
import com.yourtoken.yourtokenadmin.service.OtpService;
import com.yourtoken.yourtokenadmin.utility.DateFormat;
import com.yourtoken.yourtokenadmin.utility.NotificationMessage;
import com.yourtoken.yourtokenadmin.utility.OtpGeneration;

@Service
public class OtpServiceImpl implements OtpService {

	
	private OtpGeneration otpGeneration;
	private OtpRepositry otpRepositry;
	private DateFormat dateFormat;
	private NotificationMessage notificationMessage;
	private Otp otpObject=null;
	
	//spring create a bean for Feign client
	@Autowired
	private NotificationManagerFeginProxy notificationManagerFeginProxy;
	
	
	
	//spring create a bean for Feign client
	//@Autowired
	//private NotificationManagerFeginProxy notificationManagerFeginProxy;
	
	public OtpServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	//using constructor here we injecting the dependencies bean we are created in config package 
	
	@Autowired
	public OtpServiceImpl(OtpGeneration otpGeneration, OtpRepositry otpRepositry, DateFormat dateFormat,NotificationMessage notificationMessage) {
		super();
		this.otpGeneration = otpGeneration;
		this.otpRepositry = otpRepositry;
		this.dateFormat = dateFormat;
		this.notificationMessage=notificationMessage;
	}

	
	@Override
	public void saveOtp(Otp otp) {
		// TODO Auto-generated method stub
		otpRepositry.save(otp);
	}

	

	@Override
	public Otp getOtpObject(String emailId) {
		// TODO Auto-generated method stub
		Optional<Otp> result = otpRepositry.findById(emailId);
		if(result.isPresent()) 
		{
			
			return result.get();
		}
		
		return null;
	}
	
	
	//this method generating otp  and saving it on database 
	public void GenerationOtpAndSave(String emailId)
	{
		SimpleMailContent simpleMailContent = null;
		String  otpdigit = null;
		String createdtDate;
		otpObject = getOtpObject(emailId);
		//when first time we generating otp for this number
		if(otpObject==null)
		{
			createdtDate = dateFormat.currentDateTime();
			otpdigit = otpGeneration.getotp()+"";
			otpObject = new Otp();
			otpObject.setEmail(emailId);
			otpObject.setOtp(otpdigit);
			otpObject.setCreatedDate(createdtDate);
			otpObject.setUpdatedDate(createdtDate);
			saveOtp(otpObject);
			
		}
		else if(!otpObject.isVerfied())
		{
			createdtDate = dateFormat.currentDateTime();
			otpdigit = otpGeneration.getotp()+"";
			otpObject.setUpdatedDate(createdtDate);
			otpObject.setOtp(otpdigit);
			saveOtp(otpObject);
		}
		else if(otpObject.isVerfied())
		{
			throw new YtAdminException(" allready verfied");
		}
		//here we are invoking sendmail api using feign client
		
		simpleMailContent = notificationMessage.otpMessage(emailId, otpdigit);
		
		//here we are invoking sendmail api using feign client
		try {
				notificationManagerFeginProxy.sendMail(simpleMailContent);
			}
		catch (Exception ex) {
			// TODO: handle exception
			throw new YtAdminException("not able to send mail");
		}
		
	}

	//otp verification 
	public void VerifyOtp(String emailId, String otp)
	{
		
		otpObject = getOtpObject(emailId);
		if(otpObject==null)
		{
			throw new YtAdminException("user not found with emialId: "+emailId);
		}
		else if(otpObject!=null&&otpObject.getOtp().equals(otp))
		{	
			otpRepositry.updateVerfiedStatus(emailId, true);
		}
		else
		{
			throw new YtAdminException("Invalid Otp");
		}
	}

	

}
