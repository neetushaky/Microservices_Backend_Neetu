package com.neetu.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neetu.microservices.dto.DepartmentDto;
import com.neetu.microservices.dto.OrganizationDto;

//@FeignClient(url="http://localhost:8080",value = "DEPARTMENT-SERVICE")
@FeignClient(name="DEPARTMENT-SERVICE")

public interface APIClient {
    // Build get department rest api
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String Code);
    @GetMapping("api/organizations/{organization-code}")
    OrganizationDto getOrganizationByCode(@PathVariable("organization-code")String code);
}
		
	
	
	


