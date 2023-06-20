package com.neetu.microservices.mapper;

import com.neetu.microservices.dto.EmployeeDto;
import com.neetu.microservices.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto maptoEmployeeDto(Employee emp) {
		EmployeeDto employeeDto = new EmployeeDto(
				emp.getId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail(),
				emp.getDepartmentCode(),
				emp.getOrganizationCode());
		return employeeDto;
		
	}
	
	
	public static Employee maptoEmployee(EmployeeDto empDto) {
		Employee employee = new Employee(
				empDto.getId(),
				empDto.getFirstName(),
				empDto.getLastName(),
				empDto.getEmail(),
				empDto.getDepartmentCode(),
				empDto.getOrganizationCode());
		return employee;
		
	}

}
