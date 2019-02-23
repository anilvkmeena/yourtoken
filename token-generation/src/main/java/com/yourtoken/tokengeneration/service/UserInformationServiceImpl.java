package com.yourtoken.tokengeneration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourtoken.tokengeneration.beans.UserInformation;
import com.yourtoken.tokengeneration.dao.UserRepositry;



@Service
public class UserInformationServiceImpl implements UserInformationService {

	private UserRepositry UserRepositry;
	
	@Autowired
	public UserInformationServiceImpl(UserRepositry userRepositry) {
		super();
		UserRepositry = userRepositry;
	}

	@Override
	public void save(UserInformation userInformation) {
		// TODO Auto-generated method stub
		UserRepositry.save(userInformation);

	}

	@Override
	public UserInformation findById(int user_id) {
		// TODO Auto-generated method stub
		UserInformation userInformation= null;
		Optional<UserInformation> result= UserRepositry.findById(user_id);
		if(result.isPresent()) 
		{
			userInformation = result.get();
		}
		else
		{
			throw new RuntimeException("user not found with id: "+user_id);
		}
		return userInformation;
	}

} 
