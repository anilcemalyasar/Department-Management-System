package com.dailycodebuffer.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.Springboot.tutorial.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	

}
