package com.controller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.DepartmentsDto;
import com.controller.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/getDepartments", method = RequestMethod.GET, produces = "application/json")
    public List<DepartmentsDto> getDepartments(HttpServletRequest request, HttpServletResponse response) {
		return departmentService.getDepartments();
		
       
    }
	

}
