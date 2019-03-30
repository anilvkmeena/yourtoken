package com.yourtoken.yourtokenadmin.service;

import com.yourtoken.yourtokenadmin.model.ClientAdmin;

public interface ClientAdminService {
	public void saveClient(ClientAdmin clientAdmin);
	public ClientAdmin findClient(int clientID);
}
