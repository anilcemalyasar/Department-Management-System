package com.dailycodebuffer.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
