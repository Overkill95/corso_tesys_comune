package com.controller.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.controller.dto.UserDto;
import com.controller.entity.Employee;
import com.controller.entity.User;
import com.employees.service.EmployeeDto;

@Service
public class DtoToEntity implements Converter<EmployeeDto, Employee>{

	@Override
	public Employee convert(EmployeeDto source) {
		 
			Employee employee = new Employee();
	        employee.setFirstName(source.getFirstName());
	        employee.setLastName(source.getLastName());
	        employee.setEmail(source.getEmail());
	        employee.setPhoneNumber(source.getPhoneNumber());
	        
	       
	        Date hireDate = source.getHireDate().toGregorianCalendar().getTime();
	        employee.setHireDate(hireDate);
	   
	        
	        employee.setJobId(source.getJobId());
	        employee.setSalary(source.getSalary());
	        employee.setManagerId(source.getManagerId());
	        employee.setDepartmentId(source.getDepartmentId());

	        
	        User user = new User(); 
	        user.setUsername(source.getUser().getUsername());
	        user.setPassword(source.getUser().getPassword());
	        user.setRole(source.getUser().getRole().get(0));
	        
//	        String stringUser =  (String) source.getUser().getUsername();
//	        
//	        
	        employee.setUser(user);

	        return employee;
	}


	
	

	

}
