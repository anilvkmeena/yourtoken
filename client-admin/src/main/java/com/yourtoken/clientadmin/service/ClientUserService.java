package com.yourtoken.clientadmin.service;

import org.springframework.stereotype.Service;

import com.yourtoken.clientadmin.beans.ClientUser;

public interface ClientUserService {

	public void saveClientUser(ClientUser clientUser);
	public ClientUser getUser(int userId);
}
