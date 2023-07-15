package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.function.Predicate;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> fetchEmployeesByDepartmentId(Long departmentId) {
		Predicate<? super Employee> predicate = 
				employee -> employee.getDepartmentId() == departmentId;
				
		return employeeRepository.findAll().stream().filter(predicate).toList();
	}

	@Override
	public Employee fetchMostPaidEmployeesByDepartmentId(Long departmentId) {
		double salary = fetchEmployeesByDepartmentId(departmentId).get(0).getSalary();
		Employee mostPaidEmployee = fetchEmployeesByDepartmentId(departmentId).get(0);
		for (Employee employee : fetchEmployeesByDepartmentId(departmentId)) {		
			if(employee.getSalary() > salary) {
				mostPaidEmployee = employee;
			}
		}
		return mostPaidEmployee;
		
	}

	@Override
	public void updateEmployee(Long employeeId, Employee employee) {
		employeeRepository.deleteById(employeeId);
		employeeRepository.save(employee);
	}

	@Override
	public Employee fetchEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	
	

}
