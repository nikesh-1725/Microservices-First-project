package com.example.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Employee;
import com.example.model.AddressResponse;
import com.example.model.EmployeeResponse;
import com.example.repository.EmployeeRepository;

public class EmloyeeServiceClass {
	
	@Value("${addressService.base.url}")
	String baseUrl;
	
	private Logger LOGGER=LoggerFactory.getLogger(EmloyeeServiceClass.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	//set data by rest api call
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeResponse getEmployeeById(int id)
	{
		LOGGER.info("EmployeeResponse Class is called");
		Employee employee=employeeRepository.findById(id).get();
		
		EmployeeResponse response=modelMapper.map(employee, EmployeeResponse.class);
		
		
		AddressResponse addressResponse = restTemplate.getForObject(baseUrl+"/address/{id}", AddressResponse.class, id);
		response.setAddressResponse(addressResponse);
		 
		
		/*
		 * EmployeeResponse response=new EmployeeResponse();
		 * 
		 * response.setId(employee.getId()); response.setName(employee.getName());
		 * response.setEmail(employee.getEmail());
		 * response.setBloodgroup(employee.getBloodgroup());
		 */
		
		return response;
		
	}

}
