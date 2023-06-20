package com.neetu.microservices.service;

import com.neetu.microservices.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentdto);
	DepartmentDto GetDepartment(String code);

}
