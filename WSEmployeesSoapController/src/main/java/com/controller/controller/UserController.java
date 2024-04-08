package com.controller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.UserDto;
import com.controller.entity.User;
import com.controller.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
    public void addEmployee(@RequestBody UserDto user,HttpServletRequest request, HttpServletResponse response) {
		userService.addUser(user);
		
       
    }
	

}
