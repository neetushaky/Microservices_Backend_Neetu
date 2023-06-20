package com.neetu.microservices.service;

import org.springframework.stereotype.Service;

import com.neetu.microservices.dto.APIResponseDto;
import com.neetu.microservices.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto empDto);
	APIResponseDto getEmployee(Long EmployeeId);

}
