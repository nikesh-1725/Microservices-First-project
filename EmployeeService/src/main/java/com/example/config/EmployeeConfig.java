package com.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.service.EmloyeeServiceClass;

@Configuration
public class EmployeeConfig {
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
		
	}
	
	@Bean
	public EmloyeeServiceClass employeeServiceClass()
	{
		return new EmloyeeServiceClass();
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	

}
