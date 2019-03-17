package com.yourtoken.authorizationserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtoken.authorizationserver.beans.AuthorityData;
import com.yourtoken.authorizationserver.beans.UserData;

public interface AuthorityRepositry extends JpaRepository<AuthorityData, Integer> {

}
