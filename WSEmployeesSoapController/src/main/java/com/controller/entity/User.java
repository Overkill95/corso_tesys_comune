package com.controller.entity;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
	
	
@Entity
@Table(name = "Users_Daniel")
public class User {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
	
			
			
		
			@Id
			@Column(name = "username")
		    private String username;
		    
		    @Column(name = "password")
		    private String password;
		       
		    @Column(name = "role")
		    private String role;
		    
		    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
		    private Employee employee;
		    
//		    public Long getId() {
//				return id;
//			}
//
//			public void setId(Long id) {
//				this.id = id;
//			}

			public Employee getEmployee() {
				return employee;
			}

			public void setEmployee(Employee employee) {
				this.employee = employee;
			}

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
			
			public void setRole(String list) {
				this.role = list;
			}
}
