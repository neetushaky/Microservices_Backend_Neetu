package com.neetu.microservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neetu.microservices.Dto.OrganizationDto;
import com.neetu.microservices.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
	@Autowired
	private OrganizationService service;
	@PostMapping("/")
	public ResponseEntity<OrganizationDto> postOrganization(@RequestBody OrganizationDto organizationdto) {
		
		OrganizationDto saveOrganization =service.saveOrganization(organizationdto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveOrganization);
		
		
	}
	@GetMapping("/{organization-code}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organization-code")String code) {
		OrganizationDto organizationByCode = service.getOrganizationByCode(code);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(organizationByCode);
	}
	
	
	

}
