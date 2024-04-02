package com.controller.security;

import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.controller.entity.User;
import com.controller.repository.UserRepository;



@Component
public class PasswordEncodingUpdater {
	
//	@Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    public void updatePasswords() {
//    	List<User> users = userRepository.findAll();
//        for (User user : users) {
//            String encodedPassword = passwordEncoder.encode(user.getPassword());
//            user.setPassword(encodedPassword);
//            userRepository.save(user);
//            System.out.println("password decriptate!");
//        }
 //  }

}
