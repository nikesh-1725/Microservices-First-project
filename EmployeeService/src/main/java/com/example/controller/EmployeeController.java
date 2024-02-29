package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.EmployeeResponse;
import com.example.service.EmloyeeServiceClass;

@RestController
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employee")
	public String employee() {
		String address= restTemplate.getForObject("http://localhost:8081/address", String.class);
		
		return "Nikesh working at Eidiko  "+address;
	}
	
	@Autowired
	private EmloyeeServiceClass employeeServiceClass;
	
	@GetMapping("/details/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable int id)
	{
		EmployeeResponse employee=employeeServiceClass.getEmployeeById(id);
	//	restTemplate.getForObject("http://localhost:8081/address/{id}"+id, Address.class);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	
	
	

}
