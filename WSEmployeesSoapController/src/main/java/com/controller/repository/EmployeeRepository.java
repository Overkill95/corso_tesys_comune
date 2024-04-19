package com.controller.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controller.entity.Employee;
import com.employees.service.EmployeeDto;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value = "Select e FROM Employee e INNER JOIN e.user u WHERE u.username = :username")
	Employee getEmplByUsername(@Param("username") String user);
	
	List<Employee> findByDepartmentId(Integer departmentId );
	

}

