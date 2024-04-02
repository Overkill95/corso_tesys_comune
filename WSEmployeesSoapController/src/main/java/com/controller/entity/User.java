package com.controller.entity;
import javax.persistence.Table;


import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
	
	
@Entity
@Table(name = "Users_Daniel")
public class User {
	
	
			@Id
		  	@GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "username")
		    private String username;
		    
		    @Column(name = "password")
		    private String password;
		       
		    @Column(name = "role")
		    private String role;

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

			public String getRole() {
				return role;
			}
			
			public void setEnabled(String role) {
				this.role = role;
			}
}
