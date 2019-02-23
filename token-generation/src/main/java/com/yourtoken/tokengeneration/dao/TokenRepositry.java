package com.yourtoken.tokengeneration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtoken.tokengeneration.beans.UserToken;

public interface TokenRepositry extends JpaRepository<UserToken,Integer> {

}
