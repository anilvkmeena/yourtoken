package com.yourtoken.yourtokenadmin.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.yourtoken.yourtokenadmin.dao.ClientAdminRepositry;
import com.yourtoken.yourtokenadmin.dao.OtpRepositry;
import com.yourtoken.yourtokenadmin.exception.YtAdminException;
import com.yourtoken.yourtokenadmin.feignproxy.NotificationManagerFeginProxy;
import com.yourtoken.yourtokenadmin.model.Otp;
import com.yourtoken.yourtokenadmin.model.SimpleMailContent;
import com.yourtoken.yourtokenadmin.service.OtpService;
import com.yourtoken.yourtokenadmin.utility.DateFormat;
import com.yourtoken.yourtokenadmin.utility.NotificationMessage;
import com.yourtoken.yourtokenadmin.utility.OtpGenerator;
import com.yourtoken.yourtokenadmin.utility.PasswordGenerator;

@Service
public class OtpServiceImpl implements OtpService {

	
	private OtpGenerator otpGenerator;
	private OtpRepositry otpRepositry;
	private DateFormat dateFormat;
	private NotificationMessage notificationMessage;
	private Otp otpObject=null;
	@Autowired
	private ClientAdminRepositry clientAdminRepositry;
	private SimpleMailContent simpleMailContent = null;
	
	//spring create a bean for Feign client
	@Autowired
	private NotificationManagerFeginProxy notificationManagerFeginProxy;
	
	
	
	public OtpServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	//using constructor here we injecting the dependencies bean we are created in config package 
	
	@Autowired
	public OtpServiceImpl(OtpGenerator otpGenerator, OtpRepositry otpRepositry, DateFormat dateFormat,NotificationMessage notificationMessage) {
		super();
		this.otpGenerator = otpGenerator;
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
		
		String  otpdigit = null;
		String createdtDate;
		otpObject = getOtpObject(emailId);
		//when first time we generating otp for this number
		if(otpObject==null)
		{
			createdtDate = dateFormat.currentDateTime();
			otpdigit = otpGenerator.getotp()+"";
			otpObject = new Otp();
			otpObject.setEmail(emailId);
			otpObject.setOtp(otpdigit);
			otpObject.setCreatedDate(createdtDate);
			otpObject.setUpdatedDate(createdtDate);
			saveOtp(otpObject);
			
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
			clientAdminRepositry.updateVerfiedStatus(emailId, true);
			try {
			PasswordGenerator passwordGenerator = new PasswordGenerator();
			String tempPasswoprd = passwordGenerator.RandomPassword();
			
			simpleMailContent = notificationMessage.defaultPasswordMessage(emailId,tempPasswoprd );
			
			
			
			}
			catch (Exception e) {
				throw new YtAdminException("not able to generate password");
			}
			
			//here we are invoking sendmail api using feign client
			try {
					notificationManagerFeginProxy.sendMail(simpleMailContent);
				}
			catch (Exception ex) {
				// TODO: handle exception
				throw new YtAdminException("not able to send mail");
			}
			
		}
		else
		{
			throw new YtAdminException("Invalid Otp");
		}
	}

	

}
