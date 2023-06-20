package com.neetu.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neetu.microservices.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
	Department findByDepartmentCode(String departmentcode);

}
