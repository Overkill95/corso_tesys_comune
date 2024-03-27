package com.employees.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.employees.pojo.Employee;
import java.util.List;

@WebService
public interface EmployeeService {

	@WebMethod
	List<Employee> getAllEmployees();
}








	

