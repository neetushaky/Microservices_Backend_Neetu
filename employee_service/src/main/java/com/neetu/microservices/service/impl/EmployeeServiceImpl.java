package com.neetu.microservices.service.impl;

import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.neetu.microservices.dto.APIResponseDto;
import com.neetu.microservices.dto.DepartmentDto;
import com.neetu.microservices.dto.EmployeeDto;
import com.neetu.microservices.dto.OrganizationDto;
import com.neetu.microservices.entity.Employee;
import com.neetu.microservices.mapper.EmployeeMapper;
import com.neetu.microservices.repository.EmployeeRepository;
import com.neetu.microservices.service.APIClient;
import com.neetu.microservices.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
@Service
@ComponentScan("service/impl")
public class EmployeeServiceImpl  implements EmployeeService {
	
	 private static final org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository repo;
	//@Autowired
	//private RestTemplate restTemplate;
	//@Autowired
	//private EmployeeMapper mapper;
	
@Autowired
	private  WebClient webclient;
//	
//	@Autowired
//	private APIClient apiclient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto empDto) {
		
//		Employee employee=new Employee(
//				empDto.getId(),
//				empDto.getFirstName(),
//				empDto.getLastName(),
//				empDto.getEmail(),
//				empDto.getDepartmentCode()
//				
//				);
		Employee employee =EmployeeMapper.maptoEmployee(empDto);
		
		Employee save = repo.save(employee);
		EmployeeDto dto = EmployeeMapper.maptoEmployeeDto(employee);
//		EmployeeDto employeeDto=new EmployeeDto(
//				save.getId(),
//				save.getFirstName(),
//				save.getLastName(),
//				save.getEmail(),
//				save.getDepartmentCode()
//				);
		
		// TODO Auto-generated method stub
		return dto;
	}

	 @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	    @Override
	    public APIResponseDto getEmployee(Long employeeId) {

	        LOGGER.info("inside getEmployeeById() method");
	        Employee employee = repo.findById(employeeId).get();

//	        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//	                DepartmentDto.class);
	//
//	        DepartmentDto departmentDto = responseEntity.getBody();

	        DepartmentDto departmentDto = webclient.get()
	                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
	                .retrieve()
	                .bodyToMono(DepartmentDto.class)
	                .block();

	        //DepartmentDto departmentDto = apiclient.getDepartment(employee.getDepartmentCode());

	        OrganizationDto organizationDto = webclient.get()
	                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
	                .retrieve()
	                .bodyToMono(OrganizationDto.class)
	                .block();
	      //  OrganizationDto organizationDto = apiclient.getOrganizationByCode(employee.getOrganizationCode());

	        EmployeeDto employeeDto = EmployeeMapper.maptoEmployeeDto(employee);

	        APIResponseDto apiResponseDto = new APIResponseDto();
	        apiResponseDto.setEmployee(employeeDto);
	        apiResponseDto.setDepartment(departmentDto);
	        apiResponseDto.setOrganization(organizationDto);
	        return apiResponseDto;
	    }

	
	public APIResponseDto getDefaultDepartment(Long EmployeeId,Exception exception) {		
		LOGGER.info("Inside getDefault() method");
	
			Optional<Employee> findById = repo.findById(EmployeeId);
			Employee employee = findById.get();
			
//			ResponseEntity<DepartmentDto> forEntity = restTemplate.getForEntity(
//					"http://localhost:8080/api/departments/" 
//			+ Employee.getDepartmentCode(),DepartmentDto.class);
//			
//			DepartmentDto departmentDto = forEntity.getBody();
//			
			
			DepartmentDto departmentdto=new DepartmentDto();
			departmentdto.setDepartmentName("R&D Department");
			departmentdto.setDepartmentCode("RD001");
			departmentdto.setDepartmentDescription("Research and Development Department");
			
		//DepartmentDto departmentDto = apiclient.getDepartment(employee.getDepartmentCode());
//			EmployeeDto empDto=new EmployeeDto(
//					employee.getId(),
//					employee.getFirstName(),
//					employee.getLastName(),
//					employee.getEmail(),
//					employee.getDepartmentCode()
//					
//					
//					);
			EmployeeDto employeeDto = EmployeeMapper.maptoEmployeeDto(employee);
			
	APIResponseDto apiResponseDto=new APIResponseDto();
			apiResponseDto.setEmployee(employeeDto);
			apiResponseDto.setDepartment(departmentdto);
			
			return apiResponseDto;
		
	}
	
	
	
	
}
