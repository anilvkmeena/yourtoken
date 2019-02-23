package com.yourtoken.tokengeneration.service;

import com.yourtoken.tokengeneration.beans.UserInformation;

public interface UserInformationService {
	public void save(UserInformation userInformation);
	public UserInformation findById(int user_id);

}
