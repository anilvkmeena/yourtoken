package com.yourtoken.authorizationserver.services;

import org.springframework.stereotype.Service;

import com.yourtoken.authorizationserver.beans.AuthorityData;
import com.yourtoken.authorizationserver.dao.AuthorityRepositry;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	private AuthorityRepositry  authorityRepositry;
	
	
	public AuthorityServiceImpl(AuthorityRepositry authorityRepositry) {
		super();
		this.authorityRepositry = authorityRepositry;
	}


	@Override
	public void saveUserAuthority(AuthorityData authorityData) {
		// TODO Auto-generated method stub
		authorityRepositry.save(authorityData);
		
	}

}
