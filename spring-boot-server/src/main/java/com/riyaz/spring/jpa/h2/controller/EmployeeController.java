package com.riyaz.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.riyaz.spring.jpa.h2.model.Employees;
import com.riyaz.spring.jpa.h2.service.Employeeservice;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	Employeeservice service;

	@RequestMapping(value= "/employees", method= RequestMethod.GET)
	public List<Employees> getEmployees() {
		System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
		return service.getEmployees();
	}

	@RequestMapping(value= "/employees/{id}", method= RequestMethod.GET)
	public Employees getEmployeeById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");

		Optional<Employees> emp =  service.getEmployeeById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find employee with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/employees", method= RequestMethod.POST)
	public Employees createEmployee(@RequestBody Employees newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
		return service.addNewEmployee(newemp);
	}

	@RequestMapping(value= "/employees/{id}", method= RequestMethod.PUT)
	public Employees updateEmployee(@RequestBody Employees updemp, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");

		Optional<Employees> emp =  service.getEmployeeById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find employee with id- " + id);
			
		if(updemp.getFirstName() == null || updemp.getFirstName().isEmpty())
			updemp.setFirstName(emp.get().getFirstName());
		if(updemp.getDepartmentId() == null || updemp.getDepartmentId().isEmpty())
			updemp.setDepartmentId(emp.get().getDepartmentId());
		if(updemp.getSalary() == 0)
			updemp.setSalary(emp.get().getSalary());

		// Required for the "where" clause in the sql query template.
		updemp.setEmployeeId(id);
		return service.updateEmployee(updemp);
	}

	@RequestMapping(value= "/employees/{id}", method= RequestMethod.DELETE)
	public void deleteEmployeeById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete employee by id is invoked.");

		Optional<Employees> emp =  service.getEmployeeById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find employee with id- " + id);

		service.deleteEmployeeById(id);
	}
	
}
