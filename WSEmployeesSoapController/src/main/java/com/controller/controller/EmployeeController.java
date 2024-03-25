package com.controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.controller.service.EmplService;
import com.employees.service.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmplService emplService;
	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getEmployees(){
		return emplService.getEmployees();
	}
	
}
