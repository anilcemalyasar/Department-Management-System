package com.dailycodebuffer.Springboot.tutorial.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Managers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int managerId;
	
	private String firstName;
	private String lastName;
	private double salary;
	private Long departmentId;
	private List<Integer> employees;
	
	
}
