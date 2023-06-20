package com.neetu.microservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neetu.microservices.dto.DepartmentDto;
import com.neetu.microservices.entity.Department;
import com.neetu.microservices.mapper.DepartmentMapper;
import com.neetu.microservices.repository.DepartmentRepository;
import com.neetu.microservices.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository repo;
//	@Autowired
//	private DepartmentMapper mapper;

	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentdto) {
		
		//convert departmentdto to dpeartment jpa
		
//		Department department=new Department(
//				departmentdto.getId(),
//				departmentdto.getDepartmentName(),
//				departmentdto.getDepartmentDescription(),
//				departmentdto.getDepartmentCode()
//				);
		Department department = DepartmentMapper.maptoDepartment(departmentdto);
		
		Department save = repo.save(department);
		
		
		//convert dpeartment jpa to departmentdto
		
		
		
//		DepartmentDto saveDto=new DepartmentDto(
//				save.getId(),
//				save.getDepartmentName(),
//				save.getDepartmentDescription(),
//				save.getDepartmentCode()
//				);
		DepartmentDto departmentDto2 = DepartmentMapper.maptoDepartmentDto(save);
		
		return departmentDto2;
	}


	
	 @Override
	    public DepartmentDto GetDepartment(String departmentCode) {

	        Department department =repo.findByDepartmentCode(departmentCode);

	        DepartmentDto departmentDto = DepartmentMapper.maptoDepartmentDto(department);

	        return departmentDto;
	    }


}
