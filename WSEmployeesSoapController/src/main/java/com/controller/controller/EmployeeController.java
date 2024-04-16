package com.controller.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.controller.converter.DtoToEntity;
import com.controller.entity.Employee;
import com.controller.service.EmplService;

import com.employees.service.EmployeeDto;

@RestController
public class EmployeeController{
	
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
	
    @Autowired
    DtoToEntity converterDto;
	
	@Autowired
	EmplService emplService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeDto> getEmployees(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		SecurityContext secContext = securityContextHolderStrategy.getContext();
		String authenticationHeader = (String) request.getAttribute("Authorization");
		String authenticationHeader2 = (String) request.getHeader("Authorization");
		return emplService.getEmployees();
	}
	
	@PreAuthorize(value = "hasPermission(#id, 'EMPLOYEE_GET')")
	@RequestMapping(value="/getEmployee", method = RequestMethod.GET, produces = "application/json")
	public EmployeeDto getEmployeeById(@RequestParam("id") Integer id){
		return emplService.getEmployeeById(id);
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, produces = "application/json")
    public void addEmployee(@RequestBody EmployeeDto employee, HttpServletRequest request, HttpServletResponse response) {
		
		
//		  EmployeeDto newEmployee = new EmployeeDto();
//		  
//		  newEmployee.setEmail(employee.getEmail());
////		  newEmployee.setUser(employee.getUser().getUsername());
		 
		  
		 
//		converterDto.convert(employee);
		
		employee.getUser().setPassword(passwordEncoder.encode(employee.getUser().getPassword()));

		
		emplService.addEmployee(employee);
		
    }
	
	@PreAuthorize(value = "hasPermission(#employeeId, 'EMPLOYEE_DEL')")
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteEmployee(@PathVariable Integer employeeId) {
		emplService.deleteEmployee(employeeId);
    }
	
	@PreAuthorize(value = "hasPermission(#id, 'EMPLOYEE_UPDATE')")
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeDto updatedEmployeeDto) {
	    try {
	        emplService.updateEmployee(id, updatedEmployeeDto);
	        return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Failed to update employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	@PreAuthorize(value = "hasPermission(#departmentId, 'DEPARTMENT_DEP')")
	@RequestMapping(value="/getEmployeeByDepartment", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeDto> getEmployeeBydepartmentId(@RequestParam("id") Integer departmentId){
		return emplService.getEmployeesByDepartmentId(departmentId);
	}
	

}
