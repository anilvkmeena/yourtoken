package com.yourtoken.yourtokenadmin.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yourtoken.yourtokenadmin.model.ClientAdmin;

public interface ClientAdminRepositry extends JpaRepository<ClientAdmin, Integer> {
	// here we no need to write any code spring will spring data jpa create a bean of JpaRepository 
	//and inject it when we use JpaRepository instance to dependency.
	
	@Modifying
	@Transactional
	@Query("update ClientAdmin  set verified = ?2 WHERE client_email = ?1")
	int updateVerfiedStatus( String email, boolean verfied); // this function is able update table on basis of query


}
