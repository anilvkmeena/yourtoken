package com.yourtoken.clientadmin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourtoken.clientadmin.beans.ClientUser;
import com.yourtoken.clientadmin.dao.ClientUserRepositry;

@Service
public class ClientUserServiceImpl implements ClientUserService {

	private ClientUserRepositry clientUserRepositry;
	private ClientUser clientUser =null;
	@Autowired
	public ClientUserServiceImpl(ClientUserRepositry clientUserRepositry) {
		super();
		this.clientUserRepositry = clientUserRepositry;
	}

	@Override
	public void saveClientUser(ClientUser clientUser) {
		clientUserRepositry.save(clientUser);
		
	}

	@Override
	public ClientUser getUser(int userId) {
		// TODO Auto-generated method stub
		
		Optional<ClientUser> result= clientUserRepositry.findById(userId);
		if(result.isPresent()) 
		{
			clientUser = result.get();
		}
		else
		{
			throw new RuntimeException("user not found with id: "+userId);
		}
		return clientUser;
		
	}

}
