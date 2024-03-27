package com.employees.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.employees.pojo.Employee;
import com.employees.repository.EmployeeRepository;

@WebService(endpointInterface = "com.employees.service.EmployeeService")
public class EmployeeServiceImpl extends SpringBeanAutowiringSupport implements EmployeeService{
	
	@PostConstruct
    public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }
	

	@Autowired
	EmployeeRepository employeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = (List<Employee>) employeRepository.findAll();
		return employees;
	}
	

}
