package com.riyaz.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riyaz.spring.jpa.h2.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
	List<Employees> findByFirstName(String name);
	
}
