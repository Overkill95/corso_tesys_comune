package com.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controller.entity.Departments;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer>{

}
