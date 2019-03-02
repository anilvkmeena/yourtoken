package com.yourtoken.yourtokenadmin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourtoken.yourtokenadmin.beans.ClientAdmin;
import com.yourtoken.yourtokenadmin.dao.ClientAdminRepositry;

@Service
public class ClientAdminServiceImpl  implements ClientAdminService{

	private ClientAdminRepositry clientAdminRepositry ;
	
	@Autowired
	public ClientAdminServiceImpl(ClientAdminRepositry clientAdminRepositry) {
		super();
		this.clientAdminRepositry = clientAdminRepositry;
	}

	@Override
	public void saveClient(ClientAdmin clientAdmin) {
		 clientAdminRepositry.save(clientAdmin);
	}

	@Override
	public ClientAdmin findClient(int clientID) {
		// TODO Auto-generated method stub
		ClientAdmin clientAdmin=null;
		Optional<ClientAdmin> result  = clientAdminRepositry.findById(clientID);
		if(result.isPresent()) 
		{
			clientAdmin = result.get();
		}
		else
		{
			throw new RuntimeException("user not found with id: "+clientID);
		}
		return clientAdmin;

		
	}

}
