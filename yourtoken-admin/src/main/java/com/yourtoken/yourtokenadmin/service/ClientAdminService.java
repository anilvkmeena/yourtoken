package com.yourtoken.yourtokenadmin.service;

import com.yourtoken.yourtokenadmin.beans.ClientAdmin;

public interface ClientAdminService {
	public void saveClient(ClientAdmin clientAdmin);
	public ClientAdmin findClient(int clientID);
}
