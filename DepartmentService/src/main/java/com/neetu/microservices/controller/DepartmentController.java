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

import com.neetu.microservices.dto.DepartmentDto;
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService service;
	@PostMapping("/")
	ResponseEntity<DepartmentDto> saveUser(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto saveDepartment = service.saveDepartment(departmentDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveDepartment);
		
	}
	@GetMapping("/{department-code}")
	ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String Code) {
		DepartmentDto departmentDto = service.GetDepartment(Code);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentDto);
		
		
	}


}
