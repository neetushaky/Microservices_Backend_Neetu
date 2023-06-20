package com.neetu.microservices.service;

import org.springframework.stereotype.Service;

import com.neetu.microservices.Dto.OrganizationDto;
import com.neetu.microservices.entity.Organization;

public interface OrganizationService {
	
	public OrganizationDto saveOrganization(OrganizationDto organizationdto);
	public OrganizationDto getOrganizationByCode(String code);

}
