package com.javacodestuffs.spring.boot.rest.service;

import com.javacodestuffs.spring.boot.rest.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto addEmployee(EmployeeDto employeeDto);

	public EmployeeDto getEmployeeByUUID(String uuid);

	public EmployeeDto getEmployeeById(Long id);

	public void deleteEmployee(Long id);

	public EmployeeDto updateEmployee(EmployeeDto employeeDto);

}
