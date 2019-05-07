package com.yourtoken.yourtokenadmin.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourtoken.yourtokenadmin.dao.ClientAdminRepositry;
import com.yourtoken.yourtokenadmin.feignproxy.YtAdminFeginProxy;
import com.yourtoken.yourtokenadmin.model.ClientAdmin;
import com.yourtoken.yourtokenadmin.service.ClientAdminService;

@Service
public class ClientAdminServiceImpl  implements ClientAdminService{

	
	private ClientAdminRepositry clientAdminRepositry ;
	@Autowired
	private YtAdminFeginProxy ytAdminFeginProxy;
	
	//spring data jpa create bean of clientAdminRepositry
	@Autowired
	public ClientAdminServiceImpl(ClientAdminRepositry clientAdminRepositry) {
		super();
		this.clientAdminRepositry = clientAdminRepositry;
	}

	@Override
	public void saveClient(ClientAdmin clientAdmin) {
		String emailId = clientAdmin.getClientEmail();
		
		clientAdminRepositry.save(clientAdmin);
		ytAdminFeginProxy.otpGenerator(emailId);
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
