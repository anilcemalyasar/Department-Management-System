package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> fetchAllEmployees();

	List<Employee> fetchEmployeesByDepartmentId(Long departmentId);

	Employee fetchMostPaidEmployeesByDepartmentId(Long departmentId);

	void updateEmployee(Long employeeId, Employee employee);

	Employee fetchEmployeeById(Long employeeId);



}
