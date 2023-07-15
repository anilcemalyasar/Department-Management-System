package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DeparmentService;
import com.dailycodebuffer.Springboot.tutorial.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DeparmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, 
			@RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
	
	@GetMapping("/departments/{id}/employees")
	public List<Employee> fetchEmployeesByDepartmentId(@PathVariable("id") Long departmentId){
		return employeeService.fetchEmployeesByDepartmentId(departmentId);
	}
	
	@GetMapping("/departments/{id}/employees/mostPaid")
	public Employee fetchMostPaidEmployeesByDepartmentId(@PathVariable("id") Long departmentId){
		return employeeService.fetchMostPaidEmployeesByDepartmentId(departmentId);
	}
	
}
