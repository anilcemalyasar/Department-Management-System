package com.dailycodebuffer.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Manager;
import com.dailycodebuffer.Springboot.tutorial.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	
	@PostMapping("/managers")
	public Manager saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	
	@PutMapping("/managers/{id}")
	public Manager updateManager(@PathVariable("id") int id, 
									@RequestBody Manager manager) {
		return managerService.updateManager(id, manager);
	}
	
}
