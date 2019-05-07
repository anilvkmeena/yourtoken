package com.yourtoken.yourtokenadmin.model;

public class AuthorityData  {
	
	private int id;
	private UserData userData;
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
