package com.yourtoken.tokengeneration.dao;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtoken.tokengeneration.beans.UserInformation;

public interface UserRepositry extends JpaRepository<UserInformation, Integer> {
	
	//no need to code

}
