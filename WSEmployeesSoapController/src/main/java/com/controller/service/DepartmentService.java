package com.controller.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.DepartmentsDto;
import com.controller.entity.Departments;
import com.controller.repository.DepartmentsRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentsRepository departmentsRepository;
	
	public List<DepartmentsDto> getDepartments(){
		
		List<Departments> departments = departmentsRepository.findAll();
		
		List<DepartmentsDto> departmentsDto = departments.stream().map(department -> {
			DepartmentsDto departmentDto = new DepartmentsDto();
				departmentDto.setDepartmentId(department.getDepartmentId());
				departmentDto.setDepartmentName(department.getDepartmentName());
				departmentDto.setLocationId(department.getLocationId());
				return departmentDto;
			}).collect(Collectors.toList());
				
			return departmentsDto;
	}
	
	
	public void deleteDepartment(int id) {
		
		departmentsRepository.delete(id);
	}
	
	
	public DepartmentsDto getDepartmentById(int id) {
		Departments department = departmentsRepository.findOne(id);
		
		return convertToDto(department);
	}
	
	public DepartmentsDto convertToDto(Departments department) {
		DepartmentsDto dto = new DepartmentsDto();
		
		dto.setDepartmentId(department.getDepartmentId());
		dto.setDepartmentName(department.getDepartmentName());
		dto.setLocationId(department.getLocationId());
		
		return dto;
	}
	
}
