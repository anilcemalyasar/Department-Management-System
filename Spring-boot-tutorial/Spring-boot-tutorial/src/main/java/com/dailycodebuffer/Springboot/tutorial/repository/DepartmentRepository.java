package com.dailycodebuffer.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findByDepartmentName(String departmentName);
}
