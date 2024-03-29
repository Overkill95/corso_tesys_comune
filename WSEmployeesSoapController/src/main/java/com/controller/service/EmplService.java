package com.controller.service;


import java.util.List;
import javax.xml.ws.BindingProvider;

import org.springframework.stereotype.Service;

import com.employees.service.EmployeeDto;
import com.employees.service.EmployeeService;
import com.employees.service.EmployeeServiceImplService;


@Service
public class EmplService {

	String endpoint = "http://localhost:8080/WSEmployeesSoap/EmployeeServiceImpl";
	EmployeeServiceImplService employeeService = new EmployeeServiceImplService();
	EmployeeService port = employeeService.getEmployeeServiceImplPort();
	BindingProvider bp = (BindingProvider)port;
	
	public List <EmployeeDto> getEmployees(){
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
		return port.getAllEmployees();
	}
	
	
	public EmployeeDto getEmployeeById(int id) {
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
		return port.getEmployeeById(id);
	}
	
	public void addEmployee(EmployeeDto employee){
		
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
		port.addEmployee(employee);
		
	}
	
	
	public void deleteEmployee(Integer employee_id) {
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
        port.deleteEmployee(employee_id);
        System.out.println("Employee with id: " + employee_id + "is delete");
    }
	

	 public void updateEmployee(Integer id, EmployeeDto employee) {
		 bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
		 port.updateEmployee(id, employee);
	 }

}
