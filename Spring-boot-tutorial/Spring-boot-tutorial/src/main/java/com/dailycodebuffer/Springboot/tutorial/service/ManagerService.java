package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Manager;

public interface ManagerService {

	Manager saveManager(Manager manager);

	Manager updateManager(int id, Manager manager);

}
