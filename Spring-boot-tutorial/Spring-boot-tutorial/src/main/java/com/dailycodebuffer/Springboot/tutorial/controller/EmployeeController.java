package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployees(){
		return employeeService.fetchAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable("id") Long employeeId,
								@RequestBody Employee employee) {
		employeeService.updateEmployee(employeeId, employee);
	}
	
	
	
	
	

}
