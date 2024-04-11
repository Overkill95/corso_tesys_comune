package com.user.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
	
	private String username;
    private String password;
    private String sessionId;
    private List<String> role;
//    private String role2;
   




	private boolean authenticated;
    
    public UserDto() {}
    
 
// public String getRole2() {
//		return role2;
//	}
//
//
//
//
//
//	public void setRole2(String role2) {
//		this.role2 = role2;
//	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	



	public List<String> getRole() {
		if(this.role == null) {
			this.role = new ArrayList<String>();
		}
		return role;
	}



	public void setRole(List<String> role) {
		this.role = role;
	}
	
	public void addRole(String role) {
		this.getRole().add(role);
	}



	public boolean isAuthenticated() {
		return authenticated;
	}



	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}





	public String getSessionId() {
		return sessionId;
	}





	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
