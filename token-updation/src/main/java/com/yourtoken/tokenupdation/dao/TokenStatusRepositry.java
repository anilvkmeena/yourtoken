package com.yourtoken.tokenupdation.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yourtoken.tokenupdation.beans.TokenStatus;

public interface TokenStatusRepositry extends JpaRepository<TokenStatus, String> {
	
	@Modifying
	@Transactional
	@Query("update TokenStatus ts set ts.tokenInQueue  = ?2 where ts.tokenNumber = ?1")
	public void setTokenInQueue(String tokenNumber,String token_in_queue );
}
