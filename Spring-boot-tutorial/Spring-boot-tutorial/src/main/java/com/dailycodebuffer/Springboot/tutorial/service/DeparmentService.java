package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;

public interface DeparmentService {

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);

}
