package com.yourtoken.notificationmanager.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yourtoken.notificationmanager.bean.Otp;

public interface OtpRepositry extends JpaRepository<Otp, String> {
	
	@Modifying
	@Transactional
	@Query("update Otp o  set o.verfied = ?2 WHERE o.email = ?1")
	int updateVerfiedStatus( String email, boolean verfied);

}
