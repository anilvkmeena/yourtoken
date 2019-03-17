package com.yourtoken.authorizationserver.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.core.sym.Name;

import javassist.SerialVersionUID;

@Entity(name="authorities")
public class AuthorityData  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="username")
	private UserData userData;
	@Column(name="authority")
	//private ArrayList<SimpleGrantedAuthority> role;
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	

	

	public AuthorityData(int id, UserData userData, String role) {
		super();
		this.id = id;
		this.userData = userData;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AuthorityData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	/* =  new ArrayList<>();
	GrantedAuthority arg = new SimpleGrantedAuthority("ADMIN");
	role.add((SimpleGrantedAuthority) arg);
	UserDetails ud = new User("anil", "{noop}pass", role );*/
	
}
