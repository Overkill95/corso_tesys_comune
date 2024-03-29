package com.employees.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.employees.dto.EmployeeDto;
import com.employees.pojo.Employee;
import java.util.List;

@WebService
public interface EmployeeService {

	@WebMethod
	List<EmployeeDto> getAllEmployees();
	
	
	@WebMethod
	EmployeeDto getEmployeeById(int id);
	
	@WebMethod
	EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	
	@WebMethod
	public void deleteEmployee(Integer id);
	
	
	@WebMethod
	public void updateEmployee(Integer id, EmployeeDto updateEmployee);
}








	

