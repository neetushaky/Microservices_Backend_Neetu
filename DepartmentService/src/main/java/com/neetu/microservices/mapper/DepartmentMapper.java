package com.neetu.microservices.mapper;

import com.neetu.microservices.dto.DepartmentDto;
import com.neetu.microservices.entity.Department;

public class DepartmentMapper {
	
	public static DepartmentDto maptoDepartmentDto(Department department) {
		DepartmentDto departmentDto=new DepartmentDto(
				department.getId(),
				department.getDepartmentCode(),
				department.getDepartmentName(),
				department.getDepartmentDescription());
		return departmentDto;
	}
	
	
	public static Department maptoDepartment(DepartmentDto departmentdto) {
		Department department = new Department(
				departmentdto.getId(),
				departmentdto.getDepartmentCode(),
				departmentdto.getDepartmentName(),
				departmentdto.getDepartmentDescription());
		return department;
		
	}

}
