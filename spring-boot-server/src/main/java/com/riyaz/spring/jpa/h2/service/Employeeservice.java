package com.riyaz.spring.jpa.h2.service;

import java.util.List;
import java.util.Optional;

import com.riyaz.spring.jpa.h2.model.Employees;

public interface Employeeservice {

	public List<Employees> getEmployees();
	public Optional<Employees> getEmployeeById(int empid);
	public Employees addNewEmployee(Employees emp);
	public Employees updateEmployee(Employees emp);
	public void deleteEmployeeById(int empid);
	public void deleteAllEmployees();

}