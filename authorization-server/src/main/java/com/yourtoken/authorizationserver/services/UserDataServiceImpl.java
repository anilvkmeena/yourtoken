package com.yourtoken.authorizationserver.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yourtoken.authorizationserver.beans.UserData;
import com.yourtoken.authorizationserver.dao.UserDataRepositry;

@Service
public class UserDataServiceImpl  implements UserDataService {

	private UserDataRepositry userDataRepositry;
	
	
	@Autowired
	public UserDataServiceImpl(UserDataRepositry userDataRepositry) {
		super();
		this.userDataRepositry = userDataRepositry;
	}



	@Override
	public void saveUser(UserData data) {
		// TODO Auto-generated method stub
		System.out.println("________________________**************Q@E$*!(@$E(!$@*)");
		userDataRepositry.save(data);
	}

}
