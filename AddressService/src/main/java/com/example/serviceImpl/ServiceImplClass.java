package com.example.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.model.AddressResponse;
import com.example.repository.AddressRepository;
import com.example.service.AddressServiceClass;

@Service
public class ServiceImplClass implements AddressServiceClass {
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	ModelMapper modeMapper;

	@Override
	public AddressResponse findEmployeeById(int employeeId) {
		Address  address=addressRepo.findAddressByEmployeeId(employeeId);
		
		AddressResponse response=modeMapper.map(address, AddressResponse.class);
		return response;
	}
	
	

}
