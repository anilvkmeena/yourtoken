package com.yourtoken.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtoken.clientadmin.beans.ClientUser;

public interface ClientUserRepositry extends JpaRepository<ClientUser, Integer> {

}
