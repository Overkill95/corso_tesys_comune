package com.employees.service;

import org.springframework.stereotype.Service;

import com.employees.dto.EmployeeDto;
import com.employees.pojo.Employee;

import org.modelmapper.ModelMapper;

@Service
public class EmployeeMapperService {
	
	public EmployeeDto converToDto(Employee employee) {
		return new ModelMapper().map(employee, EmployeeDto.class);
	}
	
	public Employee convertToEntity(EmployeeDto employeeDto) {
        return new ModelMapper().map(employeeDto, Employee.class);
    }

}
