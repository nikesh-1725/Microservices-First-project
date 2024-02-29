package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AddressResponse;
import com.example.service.AddressServiceClass;

@RestController
public class AddressController {
	
	@Autowired
	private AddressServiceClass addressServiceClass;
	
	@GetMapping("/address")
	public String address()	{
		//System.out.println("Hi I am from the test method");
		
		return "RaiDurg, Hyderabad";		
	}
	@GetMapping("/address/{employee_id}")
	public AddressResponse getAddressByEmployeeId(@PathVariable("employee_id") int id) {
		
		AddressResponse response=addressServiceClass.findEmployeeById(id);
		
		
		
		return response;
		
	}
	
	

}
