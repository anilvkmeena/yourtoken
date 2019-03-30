package com.yourtoken.yourtokenadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtoken.yourtokenadmin.model.ClientAdmin;

public interface ClientAdminRepositry extends JpaRepository<ClientAdmin, Integer> {
	// here we no need to write any code spring will spring data jpa create a bean of JpaRepository 
	//and inject it when we use JpaRepository instance to dependency.

}
