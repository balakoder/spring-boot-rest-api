package com.javacodestuffs.spring.boot.rest.db.service;

 
import com.javacodestuffs.spring.boot.rest.dto.EmployeeDto;
import com.javacodestuffs.spring.boot.rest.entity.EmployeeEntity;

public interface EmployeeDbService {

	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity findEmployeeByUUID(String uuid);

	EmployeeEntity getEmployeeById(Long id);

	void deleteEmployee(Long id);

	EmployeeEntity updateEmployee(EmployeeDto employeeDto);

}
