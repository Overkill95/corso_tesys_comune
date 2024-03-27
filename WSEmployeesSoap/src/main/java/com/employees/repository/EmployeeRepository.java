package com.employees.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employees.pojo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	

}

