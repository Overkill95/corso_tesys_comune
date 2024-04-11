package com.employees.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.employees.converter.DtoToEntity;
import com.employees.dto.EmployeeDto;
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
	
	@Autowired
	EmployeeMapperService employeeMapperService;
	
	@Autowired
	DtoToEntity dtoToEntity;
	
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employees = (List<Employee>) employeRepository.findAll();
		return employees.stream()
                .map(employeeMapperService::converToDto)
                .collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		
		Employee employee = employeRepository.findOne(id);
		return new ModelMapper().map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		
		//Employee employee = employeeMapperService.convertToEntity(employeeDto);
		Employee employee = dtoToEntity.convert(employeeDto);
    	employee = employeRepository.save(employee); 
    	return employeeMapperService.converToDto(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		Optional<Employee> optionalEmployee = Optional.ofNullable(employeRepository.findOne(id));
		
		if(optionalEmployee.isPresent()) {
			Employee employeeToDelete = optionalEmployee.get();
			employeRepository.delete(employeeToDelete);
			
			System.out.println("employee: " + employeeToDelete + " delete");
		}
		else {
			System.out.println("employee with " + id + " not present");
		}
	
	}

	@Override
	public void updateEmployee(Integer id,EmployeeDto updateEmployee) {
		Optional<Employee> optionalEmployee = Optional.ofNullable(employeRepository.findOne(id));
		
		if(optionalEmployee.isPresent()) {
			Employee exstingEmployee = optionalEmployee.get();
			
			exstingEmployee.setFirstName(updateEmployee.getFirstName());
			exstingEmployee.setLastName(updateEmployee.getLastName());
			exstingEmployee.setDepartmentId(updateEmployee.getDepartmentId());
			exstingEmployee.setEmail(updateEmployee.getEmail());
			exstingEmployee.setEmployeeId(updateEmployee.getEmployeeId());
			exstingEmployee.setHireDate(updateEmployee.getHireDate());
			exstingEmployee.setJobId(updateEmployee.getJobId());
			exstingEmployee.setManagerId(updateEmployee.getManagerId());
			exstingEmployee.setPhoneNumber(updateEmployee.getPhoneNumber());
			exstingEmployee.setSalary(updateEmployee.getSalary());
			
			employeRepository.save(exstingEmployee);
			
			System.out.println("Employee update: " + exstingEmployee);
			
		}
		else{
			System.out.println("Employee with id: " + id + "not found");
		}
		
	}
	
	
	

}
