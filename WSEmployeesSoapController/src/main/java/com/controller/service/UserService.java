package com.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.controller.dto.UserDto;
import com.controller.entity.User;
import com.controller.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public void addUser(UserDto userDto) {
		 User user = new User();
		 
		 user.setUsername(userDto.getUsername());
		 user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		 

		    if (!userDto.getRole().isEmpty()) {
		        
		        String firstRole = userDto.getRole().iterator().next();
		        user.setRole(firstRole);
		    }
		
		   
		
		userRepository.save(user);
		
	}

}
