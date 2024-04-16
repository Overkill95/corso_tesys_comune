package com.controller.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.controller.dto.DepartmentsDto;
import com.controller.entity.Departments;
import com.controller.entity.Employee;
import com.controller.repository.DepartmentsRepository;
import com.controller.repository.EmployeeRepository;
import com.controller.service.EmplService;
import com.employees.service.EmployeeDto;

public class EmployeeCustomPermissionEvaluator implements PermissionEvaluator{
	
	@Autowired
	EmployeeRepository emplRepository;
	
	@Autowired
	private DepartmentsRepository departmentsRepository;

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		
		if ((authentication == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }
		
		String operazionePermesso = (String) permission;
		
		if(hasRoleAdmin(authentication.getAuthorities())){
			return true;
		}
		else if(operazionePermesso.contains("EMPLOYEE")){
			
			return checkAuthorityEmployee((Integer) targetDomainObject, authentication);
		
			
		}
		else if(operazionePermesso.contains("DEPARTMENT")){
			return checkAuthorityDepartement((Integer) targetDomainObject, authentication);
		}
		else {
			return false;
		}
			
		
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		
		return false;
	}
	
	private boolean hasRoleAdmin(Collection<? extends GrantedAuthority> collection) {
		
		for(GrantedAuthority authority :  collection) {
			if(authority.getAuthority().equals("ROLE_ADMIN")) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean checkAuthorityEmployee(Integer employeeId, Authentication authentication) {
		
		User user = (User) authentication.getPrincipal();
		
		String username = user.getUsername();
		
		Employee empl = emplRepository.findOne(employeeId);
		
		if(empl == null) {
			throw new IllegalArgumentException("ID IMPIEGATO: " + employeeId + " NON PRESENTE");
		}
		
		return empl.getUser().getUsername().equals(username);
	}
	
	
	
	private boolean checkAuthorityDepartement(Integer departmentId, Authentication authentication) {
		
		User user = (User) authentication.getPrincipal();
		
		String username = user.getUsername();
		
		Departments dep = departmentsRepository.findOne(departmentId);
		Optional<Employee> empl = emplRepository.getEmplByUsername(username);
		
		
		if(!empl.isPresent()) {
			throw new IllegalArgumentException("USERNAME IMPIEGATO: " + username + " NON PRESENTE");
		}
		
		if(dep == null) {
			throw new IllegalArgumentException("ID DIPARTIMENTO: " + departmentId + " NON PRESENTE");
		}
		
		Employee employee = empl.get();
		
		return dep.getDepartmentId().equals(employee.getDepartmentId());
		
	}

}
