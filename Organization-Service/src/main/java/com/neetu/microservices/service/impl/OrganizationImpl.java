package com.neetu.microservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neetu.microservices.Dto.OrganizationDto;
import com.neetu.microservices.entity.Organization;
import com.neetu.microservices.mapper.OrganizationMapper;
import com.neetu.microservices.repository.OrganizationRepository;
import com.neetu.microservices.service.OrganizationService;
@Service
public class OrganizationImpl implements OrganizationService {
	@Autowired
	private OrganizationRepository repo;

	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationdto) {
	
		Organization organization = OrganizationMapper.maptoOrganization(organizationdto);
		Organization save = repo.save(organization);
		OrganizationDto dto = OrganizationMapper.maptoDto(save);
		return dto;
	}

	@Override
	public OrganizationDto getOrganizationByCode(String code) {
		
		Organization organization = repo.findByOrganizationCode(code);
		OrganizationDto dto = OrganizationMapper.maptoDto(organization);
		
		// TODO Auto-generated method stub
		return dto;
	}

}
