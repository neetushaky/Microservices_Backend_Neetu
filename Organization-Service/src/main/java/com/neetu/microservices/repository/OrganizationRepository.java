package com.neetu.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neetu.microservices.Dto.OrganizationDto;
import com.neetu.microservices.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
	
	public Organization findByOrganizationCode(String OrganizationCode);

}
