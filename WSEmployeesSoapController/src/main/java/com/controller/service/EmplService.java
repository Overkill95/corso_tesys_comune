package com.controller.service;


import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.entity.Employee;
import com.controller.repository.EmployeeRepository;
import com.employees.service.EmployeeDto;
import com.employees.service.EmployeeService;
import com.employees.service.EmployeeServiceImplService;
import com.employees.service.UserDto;



@Service
public class EmplService {
	
	@Autowired
	EmployeeRepository emplRepository;

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
	 
	 public EmployeeDto findEmployeeByUsername(String username) {
	        
		 Employee employee =  emplRepository.getEmplByUsername(username);
		 return employee != null ? convertToDto(employee) : null;
		  
	    }
	 
	 
	 
	 public List<EmployeeDto> getEmployeesByDepartmentId(Integer departmentId) {
	       
		 List<Employee> employees = emplRepository.findByDepartmentId(departmentId);
	        
		 if (employees == null) {
		        return Collections.emptyList();  
		    }
		
		 return employees.stream()
                 .map(this::convertToDto)  
                 .collect(Collectors.toList());
	    }

	    private EmployeeDto convertToDto(Employee employee) {
	        
	    	EmployeeDto dto = new EmployeeDto();
	        dto.setEmployeeId(employee.getEmployeeId());
	        dto.setFirstName(employee.getFirstName());
	        dto.setLastName(employee.getLastName());
	        dto.setEmail(employee.getEmail());
	        dto.setPhoneNumber(employee.getPhoneNumber());
	        dto.setHireDate(convertToXMLGregorianCalendar(employee.getHireDate()));
	        dto.setJobId(employee.getJobId());
	        dto.setSalary(employee.getSalary());
	        dto.setManagerId(employee.getManagerId());
	        dto.setDepartmentId(employee.getDepartmentId());
	        
	        UserDto userDto = new UserDto();
	        
	        userDto.setUsername(employee.getUser().getUsername());
	        userDto.setPassword(employee.getUser().getPassword());
	        
	        
	        
	        dto.setUser(userDto);
	        
	        return dto;
	    }
	    
	    
	    
	    
	    private XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {
	        if (date == null) {
	            return null;
	        }
	        GregorianCalendar cal = new GregorianCalendar();
	        cal.setTime(date);
	        try {
	            return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	        } catch (DatatypeConfigurationException e) {
	            throw new RuntimeException(e); 
	        }
	    }

	

}
