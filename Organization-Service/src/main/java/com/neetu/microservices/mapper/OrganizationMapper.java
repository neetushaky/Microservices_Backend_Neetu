package com.neetu.microservices.mapper;

import com.neetu.microservices.Dto.OrganizationDto;
import com.neetu.microservices.entity.Organization;

public class OrganizationMapper {
	
	
	public static OrganizationDto maptoDto(Organization organization) {
		OrganizationDto organizationDto = new OrganizationDto(
				organization.getId(),
				organization.getOrganizationCode(),
				organization.getOrganizationDescription(),
				organization.getOrganizationName(),
				organization.getCreatedDate()
				);
		return organizationDto;
		
	}
	
	
	public static Organization maptoOrganization(OrganizationDto organizationDto) {
		Organization organization = new Organization(
				organizationDto.getId(),
				organizationDto.getOrganizationCode(),
				organizationDto.getOrganizationDescription(),
				organizationDto.getOrganizationName(),
				organizationDto.getCreatedDate()
				);
		return organization;
		
	}

}
