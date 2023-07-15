package com.dailycodebuffer.Springboot.tutorial.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentId;
	
	@NotBlank(message = "Please Add Department Name")
	@Length(min = 2, max = 10)
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	


	
	

}
