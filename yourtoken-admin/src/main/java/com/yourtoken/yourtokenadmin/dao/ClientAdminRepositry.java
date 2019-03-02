package com.yourtoken.yourtokenadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtoken.yourtokenadmin.beans.ClientAdmin;

public interface ClientAdminRepositry extends JpaRepository<ClientAdmin, Integer> {

}
