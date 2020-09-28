package com.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Boolean createEmployee(@RequestBody Employee employee) {
		 
		return employeeService.createEmployeeRecord(employee);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Employee getEmployeeByUsingAddressId(@RequestBody Address address) {
		Employee result= employeeService.getAddressRecord(address);
		return result;
	}
}
