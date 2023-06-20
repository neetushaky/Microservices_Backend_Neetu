package com.neetu.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neetu.microservices.dto.APIResponseDto;
import com.neetu.microservices.dto.EmployeeDto;
import com.neetu.microservices.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/")
	ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto) {
		
		EmployeeDto saveEmployee = service.saveEmployee(empDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
		
	}
	@GetMapping("{Employee-id}")
	ResponseEntity<APIResponseDto> getEmployee(@PathVariable("Employee-id") Long id){
		APIResponseDto employee = service.getEmployee(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
		
	}
	

}
