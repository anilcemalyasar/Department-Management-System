package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.entity.Manager;
import com.dailycodebuffer.Springboot.tutorial.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public Manager saveManager(Manager manager) {
		setEmployeesOfManager(manager);
		return managerRepository.save(manager);
	}
	
	public void setEmployeesOfManager(Manager manager) {
		List<Integer> employees = new ArrayList<Integer>();
		for (Employee employee : employeeService.fetchEmployeesByDepartmentId(manager.getDepartmentId())) {
			employees.add(employee.getEmployeeId().intValue());
		}
		manager.setEmployees(employees);
	}

	@Override
	public Manager updateManager(int id, Manager manager) {
		managerRepository.delete(managerRepository.findById(id).get());
		setEmployeesOfManager(manager);
		return managerRepository.save(manager);
		
		/*
		Manager managerDb = managerRepository.findById(id).get();
		
		if(Objects.nonNull(manager.getFirstName()) &&
				!"".equalsIgnoreCase(manager.getFirstName())) {
			managerDb.setFirstName(manager.getFirstName());
		}
		
		if(Objects.nonNull(manager.getLastName()) &&
				!"".equalsIgnoreCase(manager.getLastName())) {
			managerDb.setLastName(manager.getLastName());
		}
		
		if(Objects.nonNull(manager.getSalary()) &&
				!"".equalsIgnoreCase(manager.getSalary())) {
			managerDb.setLastName(manager.getLastName());
		}
		*/
	}
	
	

}
