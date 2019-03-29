package com.yourtoken.notificationmanager.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.yourtoken.notificationmanager.Utility.NotificationMessage;
import com.yourtoken.notificationmanager.Utility.OtpGeneration;
import com.yourtoken.notificationmanager.bean.Otp;
import com.yourtoken.notificationmanager.bean.SimpleMailContent;
import com.yourtoken.notificationmanager.dao.OtpRepositry;
import com.yourtoken.notificationmanager.feginproxy.NotificationManagerFeginProxy;
import com.yourtoken.notificationmanager.service.OtpService;


@Service
public class OtpServiceImpl implements OtpService {

	private OtpGeneration otpGeneration;
	private OtpRepositry otpRepositry;
	private Otp OtpData=null;
	@Autowired
	private NotificationManagerFeginProxy notificationManagerFeginProxy;
	private NotificationMessage notificationMessage;
	public OtpServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public OtpServiceImpl(OtpGeneration otpGeneration, OtpRepositry otpRepositry,NotificationMessage notificationMessage) {
		super();
		this.otpGeneration = otpGeneration;
		this.otpRepositry = otpRepositry;
		this.notificationMessage=notificationMessage;
	}

	@Override
	public void saveOtp(Otp otp) {
		// TODO Auto-generated method stub
		otpRepositry.save(otp);
	}

	@Override
	public void getOtp(String email) {
		// TODO Auto-generated method stub
		Optional<Otp> result = otpRepositry.findById(email);
		if(result.isPresent()) 
		{
			OtpData= result.get();
		}
		else
		{
			throw new RuntimeException("user not found with id: "+email);
		}
	}
	
	

	public String GenerationOtpAndSave(String emailId)
	{
		SimpleMailContent simpleMailContent = null;
		
		String  otpdigit;
		otpdigit = otpGeneration.getotp()+"";
		Otp otp = new Otp();
		otp.setEmail(emailId);
		otp.setOtp(otpdigit);
		saveOtp(otp);
		simpleMailContent = notificationMessage.otpsendMessage(emailId, otpdigit);
		return notificationManagerFeginProxy.sendMail(simpleMailContent);
		
		
	}
	
	public boolean VerifyOtp(String email, String otp)
	{
		getOtp(email);
		if(OtpData!=null&&OtpData.getOtp().equals(otp))
		{	otpRepositry.updateVerfiedStatus(email, true);
			return true;
		}
		return false;
	}

	

}
