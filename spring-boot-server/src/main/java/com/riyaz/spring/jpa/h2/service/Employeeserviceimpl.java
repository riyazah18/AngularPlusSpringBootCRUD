package com.riyaz.spring.jpa.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyaz.spring.jpa.h2.dao.Mydaorepository;
import com.riyaz.spring.jpa.h2.model.Employees;

@Service
public class Employeeserviceimpl implements Employeeservice {

	@Autowired
	Mydaorepository dao;

	@Override
	public List<Employees> getEmployees() {
		return dao.findAll();
	}
	@Override
	public Optional<Employees> getEmployeeById(int empid) {
		return dao.findById(empid);
	}
	@Override
	public Employees addNewEmployee(Employees emp) {
		return dao.save(emp);
	}
	@Override
	public Employees updateEmployee(Employees emp) {
		return dao.save(emp);
	}
	@Override
	public void deleteEmployeeById(int empid) {
		dao.deleteById(empid);
	}
	@Override
	public void deleteAllEmployees() {
		dao.deleteAll();
	}
}