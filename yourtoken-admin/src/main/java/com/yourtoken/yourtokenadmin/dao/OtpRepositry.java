package com.yourtoken.yourtokenadmin.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.yourtoken.yourtokenadmin.model.Otp;
public interface OtpRepositry extends JpaRepository<Otp, String> {
	//JpaRepository provide CRUD feature free so we no need to define them
	
	/*@Modifying
	@Transactional
	@Query("update Otp o  set o.verfied = ?2 WHERE o.email = ?1")
	int updateVerfiedStatus( String email, boolean verfied); // this function is able update table on basis of query
*/
}
